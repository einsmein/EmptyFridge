package library.controller;

import library.repository.RecipeRepository;
import library.models.Recipe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeRepository recipeRepo;

    public RecipeController(RecipeRepository repo){
        this.recipeRepo = repo;
    }

    @RequestMapping("/all")
    public Iterable<Recipe> getRecipe(){
        return recipeRepo.findAll();
    }

    @PostMapping("/add")
    public void addRecipe(@RequestBody Recipe recipe){
        recipeRepo.save(recipe);
    }
}
