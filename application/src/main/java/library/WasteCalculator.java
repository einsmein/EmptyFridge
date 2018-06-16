package library;

import com.fasterxml.jackson.databind.ObjectMapper;
import library.models.*;
import library.repository.IngredientRepository;
import library.repository.RecipeRepository;
import org.springframework.data.util.Pair;

import java.util.*;

public class WasteCalculator {
    private RecipeRepository recRepo;
    private IngredientRepository ingRepo;
    ObjectMapper mapper = new ObjectMapper();

    public WasteCalculator(RecipeRepository recRepo, IngredientRepository ingRepo){
        this.recRepo = recRepo; this.ingRepo = ingRepo;
    }

    public IngredientAmountMap getAllIngredient(Iterable<Recipe> recipes){
        IngredientAmountMap sumIngredient = new IngredientAmountMap();

        for (Recipe rec : recipes){
            IngredientAmountMap thisRecipe = new IngredientAmountMap(rec.getIngredientsAmount());
            for (String ingName: thisRecipe.getIngredientSet()){
                sumIngredient.update(ingName, thisRecipe.getAmount(ingName)+ sumIngredient.getAmount(ingName));
            }
        }

        return sumIngredient;
    }

    public IngredientAmountMap getAllIngredient(IngredientAmountMap collection, IngredientAmountMap diff){
        IngredientAmountMap newCollection = new IngredientAmountMap();
        for(String ingName: diff.getIngredientSet()){
            newCollection.update(ingName, collection.getAmount(ingName) + diff.getAmount(ingName));
        }

        return newCollection;
    }

    public IngredientSummaryMap getIngredientSummary(IngredientAmountMap allIngredients){
        IngredientSummaryMap summaryCollection = new IngredientSummaryMap();

        for(String ingName: allIngredients.getIngredientSet()){
            Ingredient ing = ingRepo.findByName(ingName);
            double amount = allIngredients.getAmount(ingName);
            int piece = (int) Math.ceil(amount/ing.getPortion());
            double price = piece*ing.getPrice();
            double leftover = piece*ing.getPortion() - amount;
            double wasteScore = ing.getWastePenalty()*(1.0/(1+Math.pow(ing.getDayTillExp(),1.0/6)))*leftover;

            summaryCollection.add(ing.getName(), new IngredientSummary(piece, price, leftover, Math.round(wasteScore*100.0)/100.0));
        }

        return summaryCollection;
    }

    // recipes: chosen set of recipe
    public List<SuggestionSummary> getSuggestion(List<Recipe> recipes, IngredientAmountMap ingredients, IngredientSummaryMap summary){
        double oldWasteScore = summary.getWasteScore();
        double oldPrice = summary.getPrice();
        ArrayList<String> recipeNames = new ArrayList<>();
        recipes.forEach(rec -> recipeNames.add(rec.getName()));

        // Suggestions as a MAX HEAP of size 10
        PriorityQueue<SuggestionSummary> suggestions = new PriorityQueue(10, Collections.reverseOrder());
        int maxSuggestion = 7;

        // Create a list of ALL recipes in the database
        // and a list of the CHOSEN recipes
        Iterable<Recipe> allRecipes = recRepo.findAll();
//        ArrayList<Recipe> oldRecipeList = new ArrayList<>();
//        recipes.forEach(rec -> oldRecipeList.add(rec));

        // Try sub each chosen recipe with each recipes in the database
        for (Recipe chosenRec: recipes){
            for (Recipe newRec: allRecipes){
                if(recipeNames.contains(newRec.getName())) continue;
                if(chosenRec.getName().equals(newRec.getName())) continue;

                // Get new summary and check if waste score reduces.
                // If it does, calculate delta to create summary of substitution
                IngredientAmountMap diff = getDiffIngredientAmount(chosenRec, newRec);
                IngredientAmountMap newIngredients = getAllIngredient(ingredients, diff);
                IngredientSummaryMap newSummaries = getIngredientSummary(newIngredients);
                double newWasteScore = newSummaries.getWasteScore();
                double newPrice = newSummaries.getPrice();
                if(newWasteScore > oldWasteScore) continue;

                // If heap is not full, add new sub
                // If full, peek the maximum SuggestionSummary, if waste score is higher than new sub, replace it
                // TODO: calculate diff waste amount
                SuggestionSummary suggestionSummary = new SuggestionSummary(
                        chosenRec,
                        newRec,
                        getDiffWaste(summary, newSummaries),
                        Math.round((newWasteScore-oldWasteScore)*100.0)/100.0,
                        newPrice-oldPrice);
                if (suggestions.size() < maxSuggestion){
                    suggestions.add(suggestionSummary);
                }
                else if (suggestionSummary.hasLowerWaste(suggestions.peek())){
                    suggestions.poll();
                    suggestions.add(suggestionSummary);
                }

                try {
                    System.out.println("Sub menu: " + chosenRec.getName() + " -> " + newRec.getName());
                    System.out.println("Ingredient diff: " + diff.toString());
                    System.out.println("Waste score: " + oldWasteScore + " -> " + newWasteScore);
                    System.out.println(newSummaries.toString());
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        ArrayList<SuggestionSummary> suggestionList = new ArrayList<>();
        SuggestionSummary subSum;
        while((subSum = suggestions.poll()) != null){
            suggestionList.add(subSum);
        }
        return suggestionList;
    }

    public IngAndSuggestionResponse getIngAndSuggestion(Iterable<Recipe> recipes){
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipes.forEach(rec -> recipeList.add(rec));
        IngredientAmountMap ingredients = getAllIngredient(recipes);
        IngredientSummaryMap summary = getIngredientSummary(ingredients);

        List<SuggestionSummary> suggestions = getSuggestion(recipeList, ingredients, summary);
        Collections.reverse(suggestions);

        IngAndSuggestionResponse response = new IngAndSuggestionResponse();
        response.ingredientsSummary = summary.getIngredientSummaryEntries();
        response.suggestionList = suggestions;
        response.totalWaste = summary.getWasteScore();
        response.totalPrice = summary.getPrice();

        return response;
    }

    public List<IngredientAmountEntry> getDiffWaste(IngredientSummaryMap oldSum, IngredientSummaryMap newSum){
        IngredientAmountMap diffWaste = new IngredientAmountMap();
        List<IngredientSummaryEntry> oldSumList = oldSum.getIngredientSummaryEntries();
        List<IngredientSummaryEntry> newSumList = newSum.getIngredientSummaryEntries();
        for(IngredientSummaryEntry newIngSum: newSumList){
            diffWaste.add(newIngSum.ingredientName, newIngSum.wasteAmount);
        }
        for(IngredientSummaryEntry oldIngSum: oldSumList) {
            if(diffWaste.has(oldIngSum.ingredientName)){
                double prev = diffWaste.getAmount(oldIngSum.ingredientName);
                diffWaste.update(oldIngSum.ingredientName, prev - oldIngSum.wasteAmount);
            }
            else{
                diffWaste.update(oldIngSum.ingredientName, -oldIngSum.wasteAmount);
            }
        }

        for(IngredientAmountEntry e : diffWaste.getIngredientAmountEntries()){
            if(e.amount == 0){
                diffWaste.remove(e.ingredientName);
            }
        }
        return diffWaste.getIngredientAmountEntries();
    }

    public IngredientAmountMap getDiffIngredientAmount(Recipe oldRec, Recipe newRec){
        IngredientAmountMap diffIngredient = new IngredientAmountMap();
        for(Pair<String, Double> ing: oldRec.getIngredientsAmount()){
            diffIngredient.update(ing.getFirst(), -ing.getSecond());
        }
        for(Pair<String, Double> ing: newRec.getIngredientsAmount()){
            double amount = diffIngredient.getAmount(ing.getFirst());
            diffIngredient.update(ing.getFirst(), amount + ing.getSecond());
        }
        return diffIngredient;
    }

}
