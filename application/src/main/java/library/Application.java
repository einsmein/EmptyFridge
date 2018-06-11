package library;

import library.models.Ingredient;
import library.models.Recipe;
import library.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.util.Pair;

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

//        ArrayList<Pair<Ingredient, Double>> ingList = new ArrayList<>();
//        ingList.add(Pair.of(pork, 100.0));
//        ingList.add(Pair.of(ketchup, 50.0));
//
//        Recipe rec = new Recipe("steak", ingList);
//        recipeRepo.insert(rec);
//
//        ingList.clear();
//        rec = new Recipe("empty", ingList);
//        recipeRepo.insert(rec);
    }

}
