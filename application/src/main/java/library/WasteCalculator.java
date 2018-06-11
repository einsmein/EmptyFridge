package library;

import library.models.Ingredient;
import library.models.Recipe;
import library.models.WasteIngredient;
import library.repository.RecipeRepository;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WasteCalculator {
    private RecipeRepository repo;
    public WasteCalculator(RecipeRepository repo){
        this.repo = repo;
    }

    public Map<Ingredient, Double> getSumIngredient(Iterable<Recipe> recipes){
        // Map of ingredient Id and total amount for all recipes
        Map<Ingredient, Double> ingredients = new HashMap<>();

        // Convert a list of recipes into a map of ingredient id and total amount
        for (Recipe rec : recipes) {
            for (Pair<Ingredient, Double> p : rec.getIngredientsAmount()) {
                Ingredient ing = p.getFirst();
                double amount = ingredients.get(ing);
                if (ingredients.containsKey(ing)) {
                    amount += p.getSecond();
                    ingredients.replace(ing, amount);
                } else {
                    ingredients.put(ing, amount);
                }
            }
        }
        return ingredients;

    }

    // recipes: chosen set of recipe
    public double getWasteScore(Iterable<Recipe> recipes) {
        // Map of ingredient Id and total amount for all recipes
        Map<Ingredient, Double> summedIngredients = getSumIngredient(recipes);
        List<WasteIngredient> wasteIngredients = new ArrayList<>();

        // Penalty for leftover = Expire date weight * Penalty weight * Remaining gram (of ingredient j)
        double wasteScore = 0;
        for(Map.Entry<Ingredient, Double> entry: summedIngredients.entrySet()){
            Ingredient ing = entry.getKey();
            double amount = entry.getValue();
            double leftover = Math.ceil(amount/ing.getPortion())*ing.getPortion() - amount;
            wasteScore += ing.getWastePenalty()*ing.getDayTillExp()*leftover;
        }

        return wasteScore;
    }

    // recipes: chosen set of recipe
    // return
    public Map <Pair<Recipe,Recipe>, Double> getSuggestion(Iterable<Recipe> recipes){
        double wasteScore = getWasteScore(recipes);

        Iterable<Recipe> allRecipes = repo.findAll();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipes.forEach(rec -> recipeList.add(rec));
        Map<Pair<Recipe, Recipe>, Double> recipeSubMap = new HashMap<>();
//        Map<Double, List<Pair<Recipe,Recipe>>>

        for (Recipe chosenRec: recipeList){
            for (Recipe newRec: allRecipes){
                recipeList.remove(chosenRec);
                recipeList.add(newRec);

                double newSubScore = getWasteScore(recipeList);
//                if(!recipeSubMap.containsKey(chosenRec)){
//                    recipeSubMap.put(new Pair(chosenRec, newRec), newSubScore);
//                }

//                double currentSubScore = recipeSubMap.get(new Pair(chosenRec, newRec));
                if (newSubScore < wasteScore) {
                    recipeSubMap.put(Pair.of(chosenRec, newRec), newSubScore);
                }
            }
        }

        Map<Pair<Recipe, Recipe>, Double> sortedRecipeSubMap
                = recipeSubMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, HashMap::new));

        return sortedRecipeSubMap;
    }
}
