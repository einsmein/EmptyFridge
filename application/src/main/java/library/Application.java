package library;

import javafx.util.Pair;
import library.models.Ingredient;
import library.models.Recipe;
import library.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    RecipeRepository recipeRepo;

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Ingredient pork = new Ingredient("pork", 1.0, 5, 235);
        Ingredient ketchup = new Ingredient("ketchup", 0.5, 100, 150);

        ArrayList<Pair<Ingredient, Double>> ingList = new ArrayList<>();
        ingList.add(new Pair(pork, 100.0));
        ingList.add(new Pair(ketchup, 50));
        Recipe rec = new Recipe("steak", ingList);
        recipeRepo.insert(rec);

        ingList.clear();
        rec = new Recipe("", ingList);
        recipeRepo.insert(rec);
    }

}
