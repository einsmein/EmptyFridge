package library.controller;

import library.WasteCalculator;
import library.models.*;
import library.repository.IngredientRepository;
import library.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
        RecipeRepository recipeRepo;
        IngredientRepository ingredientRepo;
        WasteCalculator wasteCalculator;

    public CalculatorController(RecipeRepository recRepo, IngredientRepository ingRepo){
            this.recipeRepo = recRepo;
            this.ingredientRepo = ingRepo;
            wasteCalculator = new WasteCalculator(recipeRepo, ingRepo);
        }

    @RequestMapping("/test")
    public Iterable<SuggestionSummary> test(){
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipeRepo.findByName("X1"));
        recipeList.add(recipeRepo.findByName("X5"));

        return wasteCalculator.getIngAndSuggestion(recipeList).suggestionList;
    }

    @PostMapping("/calculate")
//    public IngAndSuggestionResponse calculateWasteFromRecipes(@ModelAttribute ArrayList<String> recipeNames){
    public IngAndSuggestionResponse calculate(@RequestBody String[] recipeNames){
        ArrayList<Recipe> recipes = new ArrayList<>();
        for(String r: recipeNames){
            recipes.add(recipeRepo.findByName(r));
        }

        return wasteCalculator.getIngAndSuggestion(recipes);
    }
}
