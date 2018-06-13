package library.controller;

import library.WasteCalculator;
import library.models.Ingredient;
import library.models.Recipe;
import library.models.SubSummary;
import library.repository.IngredientRepository;
import library.repository.RecipeRepository;
import org.springframework.data.util.Pair;
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
        Ingredient pork = new Ingredient("pork", 2.0, 5, 235.0);
        ArrayList<Pair<Ingredient, Double>> ingList = new ArrayList<>();
        ingList.add(Pair.of(pork, 200.0));
        Recipe rec1 = new Recipe("Test Menu Pork Base", ingList);
        ingList.clear();

        ingList.add(Pair.of(pork, 40.0));
        Recipe rec2 = new Recipe("Test Menu Pork 40 (Bad comb)", ingList);
        ingList.clear();


        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipeRepo.findByName("Test Menu Pork Base"));
        recipeList.add(recipeRepo.findByName("Test Menu Pork 40 (Bad comb)"));

        String res = "";
        for(SubSummary rec: wasteCalculator.getSuggestion(recipeList)){

        }
        return wasteCalculator.getSuggestion(recipeList);
    }
}
