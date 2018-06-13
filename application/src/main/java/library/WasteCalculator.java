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
            double wasteScore = ing.getWastePenalty()*(1.0/ing.getDayTillExp())*leftover;

            summaryCollection.add(ing.getName(), new IngSummaryInfo(piece, leftover, wasteScore));
        }

        return summaryCollection;
    }


    // recipes: chosen set of recipe
    public double getWasteScore(Iterable<IngSummaryInfo> ingSummaryInfos) {
        double wasteScore = 0;
        for(IngSummaryInfo ing: ingSummaryInfos){
            wasteScore += ing.wasteScore;
        }
        return wasteScore;
    }

    // recipes: chosen set of recipe
    public List<SubSummary> getSuggestion(Iterable<Recipe> recipes){
        IngAmountCollection oldIngredient = getAllIngredient(recipes);
        IngSummaryCollection oldSummaries = getSummary(oldIngredient);
        double oldWasteScore = oldSummaries.getWasteScore();

        // Suggestions as a MAX HEAP of size 10
        PriorityQueue<SubSummary> suggestions = new PriorityQueue(10, Collections.reverseOrder());
        int maxSuggestion = 7;

        // Create a list of ALL recipes in the database
        // and a list of the CHOSEN recipes
        Iterable<Recipe> allRecipes = recRepo.findAll();
        ArrayList<Recipe> oldRecipeList = new ArrayList<>();
        ArrayList<Recipe> newRecipeList = new ArrayList<>();
        recipes.forEach(rec -> oldRecipeList.add(rec));
        recipes.forEach(rec -> newRecipeList.add(rec));

        // Try sub each chosen recipe with each recipes in the database
        for (Recipe chosenRec: oldRecipeList){
            for (Recipe newRec: allRecipes){
                if(oldRecipeList.contains(newRec)) continue;
                newRecipeList.remove(chosenRec);
                newRecipeList.add(newRec);

                // Get new summary and check if waste score reduces.
                // If it does, calculate delta to create summary of substitution
                IngAmountCollection diff = getDiffIngredientAmount(chosenRec, newRec);
                IngAmountCollection newIngredients = getAllIngredient(oldIngredient, diff);
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
                    System.out.println("New list: " + mapper.writeValueAsString(newRecipeList));
                    System.out.println("Ingredient diff: " + diff.toString());
                    System.out.println("Waste score: " + oldWasteScore + " -> " + newWasteScore);
                    System.out.println("Ingredient list: " + oldIngredient.toString() + " -> " + newIngredients.toString());
                    System.out.println(newSummaries.toString());
                } catch(Exception e){
                    e.printStackTrace();
                }
                newRecipeList.remove(newRec);
                newRecipeList.add(chosenRec);
            }
        }

        ArrayList<SubSummary> suggestionList = new ArrayList<>();
        SubSummary subSum;
        while((subSum = suggestions.poll()) != null){
            suggestionList.add(subSum);
        }
        return suggestionList;
    }

    public IngAmountCollection getDiffIngredientAmount(Recipe oldRec, Recipe newRec){
        IngAmountCollection diffIngredient = new IngAmountCollection();
        for(Pair<Ingredient, Double> ing: oldRec.getIngredientsAmount()){
            diffIngredient.update(ing.getFirst().getName(), -ing.getSecond());
        }
        for(Pair<Ingredient, Double> ing: newRec.getIngredientsAmount()){
            double amount = diffIngredient.getAmount(ing.getFirst().getName());
            diffIngredient.update(ing.getFirst().getName(), amount + ing.getSecond());
        }
        return diffIngredient;
    }

}
