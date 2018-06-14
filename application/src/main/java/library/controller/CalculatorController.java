package library.controller;

import library.WasteCalculator;
import library.models.IngAndSuggestionResponse;
import library.models.Ingredient;
import library.models.Recipe;
import library.models.SubSummary;
import library.repository.IngredientRepository;
import library.repository.RecipeRepository;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public Iterable<SubSummary> test(){
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipeRepo.findByName("X1"));
        recipeList.add(recipeRepo.findByName("X5"));

        return wasteCalculator.getIngAndSuggestion(recipeList).suggestionList;
    }

    @PostMapping("/calculate")
//    public IngAndSuggestionResponse calculateWasteFromRecipes(@ModelAttribute ArrayList<String> recipeNames){
    public String calculateWasteFromRecipes(@ModelAttribute ArrayList<String> recipeNames){
        ArrayList<Recipe> recipes = new ArrayList<>();
        String name = "X";
        for(String r: recipeNames){
            name = r;
            recipes.add(recipeRepo.findByName(r));
        }
        return name;
    }
}
