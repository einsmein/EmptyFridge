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

    public IngAmountCollection getAllIngredient(Iterable<Recipe> recipes){
        IngAmountCollection sumIngredient = new IngAmountCollection();

        for (Recipe rec : recipes){
            IngAmountCollection thisRecipe = new IngAmountCollection(rec.getIngredientsAmount());
            for (String ingName: thisRecipe.getIngredientSet()){
                sumIngredient.update(ingName, thisRecipe.getAmount(ingName)+ sumIngredient.getAmount(ingName));
            }
        }

        return sumIngredient;
    }

    public IngAmountCollection getAllIngredient(IngAmountCollection collection, IngAmountCollection diff){
        IngAmountCollection newCollection = new IngAmountCollection();
        for(String ingName: diff.getIngredientSet()){
            newCollection.update(ingName, collection.getAmount(ingName) + diff.getAmount(ingName));
        }

        return newCollection;
    }

    public IngSummaryCollection getSummary(IngAmountCollection allIngredients){
        IngSummaryCollection summaryCollection = new IngSummaryCollection();

        for(String ingName: allIngredients.getIngredientSet()){
            Ingredient ing = ingRepo.findByName(ingName);
            double amount = allIngredients.getAmount(ingName);
            int piece = (int) Math.ceil(amount/ing.getPortion());
            double leftover = piece*ing.getPortion() - amount;
            double wasteScore = ing.getWastePenalty()*(1.0/(1+Math.pow(ing.getDayTillExp(),1.0/6)))*leftover;

            summaryCollection.add(ing.getName(), new IngSummaryInfo(piece, leftover, wasteScore));
        }

        return summaryCollection;
    }

    // recipes: chosen set of recipe
    public List<SubSummary> getSuggestion(List<Recipe> recipes, IngAmountCollection ingredients, IngSummaryCollection summary){
        double oldWasteScore = summary.getWasteScore();

        // Suggestions as a MAX HEAP of size 10
        PriorityQueue<SubSummary> suggestions = new PriorityQueue(10, Collections.reverseOrder());
        int maxSuggestion = 7;

        // Create a list of ALL recipes in the database
        // and a list of the CHOSEN recipes
        Iterable<Recipe> allRecipes = recRepo.findAll();
//        ArrayList<Recipe> oldRecipeList = new ArrayList<>();
//        recipes.forEach(rec -> oldRecipeList.add(rec));

        // Try sub each chosen recipe with each recipes in the database
        for (Recipe chosenRec: recipes){
            for (Recipe newRec: allRecipes){
                if(recipes.contains(newRec)) continue;

                // Get new summary and check if waste score reduces.
                // If it does, calculate delta to create summary of substitution
                IngAmountCollection diff = getDiffIngredientAmount(chosenRec, newRec);
                IngAmountCollection newIngredients = getAllIngredient(ingredients, diff);
                IngSummaryCollection newSummaries = getSummary(newIngredients);
                double newWasteScore = newSummaries.getWasteScore();

                // If heap is not full, add new sub
                // If full, peek the maximum SubSummary, if waste score is higher than new sub, replace it
                // TODO: calculate diff waste amount
                SubSummary subSummary = new SubSummary(chosenRec, newRec, new IngAmountCollection(), newWasteScore-oldWasteScore);
                if (suggestions.size() < maxSuggestion){
                    suggestions.add(subSummary);
                }
                else if (subSummary.hasLowerWaste(suggestions.peek())){
                    suggestions.poll();
                    suggestions.add(subSummary);
                }

                try {
                    System.out.println("Sub menu: " + chosenRec.getName() + " -> " + newRec.getName());
                    System.out.println("Ingredient diff: " + diff.toString());
                    System.out.println("Waste score: " + oldWasteScore + " -> " + newWasteScore);
//                    System.out.println("Ingredient list: " + oldIngredient.toString() + " -> " + newIngredients.toString());
                    System.out.println(newSummaries.toString());
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        ArrayList<SubSummary> suggestionList = new ArrayList<>();
        SubSummary subSum;
        while((subSum = suggestions.poll()) != null){
            suggestionList.add(subSum);
        }
        return suggestionList;
    }

    public IngAndSuggestionResponse getIngAndSuggestion(Iterable<Recipe> recipes){
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipes.forEach(rec -> recipeList.add(rec));
        IngAmountCollection ingredients = getAllIngredient(recipes);
        IngSummaryCollection summary = getSummary(ingredients);

        List<SubSummary> suggestions = getSuggestion(recipeList, ingredients, summary);

        IngAndSuggestionResponse response = new IngAndSuggestionResponse();
        response.ingredientsSummary = summary;
        response.suggestionList = suggestions;

        return response;
    }

    public IngAmountCollection getDiffIngredientAmount(Recipe oldRec, Recipe newRec){
        IngAmountCollection diffIngredient = new IngAmountCollection();
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
