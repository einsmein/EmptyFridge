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

        recipeRepo.deleteAll();
        // TODO: Add ingredients
        Ingredient pork = new Ingredient("pork", 2.0, 5, 235.0);
        Ingredient outerFilletPork = new Ingredient("outer fillet pork", 2.0, 5, 730.0);
        Ingredient beefSirloin = new Ingredient("beef sirloin", 2.0, 5, 365.0);
        Ingredient shrimp = new Ingredient("shrimp", 2.0, 7, 200.0);
        Ingredient chickenFillet = new Ingredient("chicken fillet", 2.0, 5, 200.0);
        Ingredient salmonFillet = new Ingredient("salmon fillet", 2.0, 3, 200.0);
        Ingredient bacon = new Ingredient("bacon", 2.0, 7, 200.0);
        Ingredient ham = new Ingredient("ham", 2.0, 7, 100.0);

        Ingredient potato = new Ingredient("potato", 1.8, 21, 1000.0);
        Ingredient mushroom = new Ingredient("mushroom", 1.8, 5, 250.0);
        Ingredient egg = new Ingredient("egg", 1.8, 7, 800.0);
        Ingredient mayonnaise = new Ingredient("mayonnaise", 1.8, 60, 160.0);
        Ingredient butter = new Ingredient("butter", 1.8, 180, 250.0);
        Ingredient flour = new Ingredient("flour", 1.8, 365, 1000.0);
        Ingredient heavyCream = new Ingredient("heavy cream", 1.8, 6, 300.0); // 300 in ml
        Ingredient fettuccine = new Ingredient("fettuccine", 1.8, 365, 500.0);
        Ingredient spaghetti = new Ingredient("spaghetti", 1.8, 365, 500.0);
        Ingredient cheese = new Ingredient("cheese", 1.8, 60, 300.0);
        Ingredient milk = new Ingredient("milk", 1.8, 6, 1000.0); // in ml
        //Ingredient rice = new Ingredient("rice", 1.8, 180, 1000);

        Ingredient chili = new Ingredient("chili", 1.3, 4, 50.0);
        Ingredient coriander = new Ingredient("coriander", 1.3, 5, 20.0);
        Ingredient garlic = new Ingredient("garlic", 1.3, 120, 100.0);
        Ingredient ginger = new Ingredient("ginger", 1.3, 30, 100.0);
        Ingredient pakChoi = new Ingredient("pak choi", 1.3, 7, 125.0);
        Ingredient springOnion = new Ingredient("spring onion", 1.3, 7, 150.0);
        Ingredient onion = new Ingredient("onion", 1.3, 30, 630.0);
        Ingredient turmeric = new Ingredient("turmeric", 1.3, 365, 70.0);
        Ingredient cayennePepper = new Ingredient("cayenne pepper", 1.3, 365, 62.0);
        Ingredient lemongrass = new Ingredient("lemongrass", 1.3, 14, 50.0);
        Ingredient bellPepper = new Ingredient("bell pepper", 1.3, 14, 260.0);
        Ingredient shallot = new Ingredient("shallot", 1.3, 14, 200.0);
        Ingredient capers = new Ingredient("capers", 1.3, 365, 100.0);
        Ingredient celery = new Ingredient("celery", 1.3, 14, 500.0);
        Ingredient lemon = new Ingredient("lemon", 1.3, 14, 380.0);
        Ingredient orange = new Ingredient("orange", 1.3, 10, 320.0);
        Ingredient lemonJuice = new Ingredient("lemon juice", 1.3, 120, 250.0); // 250 in ml
        Ingredient chickenBroth = new Ingredient("chicken broth", 1.3, 180, 112.0);
        Ingredient parsley  = new Ingredient("parsley", 1.3, 14, 20.0);
        Ingredient basil  = new Ingredient("basil", 1.3, 5, 20.0);
        Ingredient thyme  = new Ingredient("thyme", 1.3, 7, 20.0);
        Ingredient bayLeaf  = new Ingredient("bay leaf", 1.3, 365, 2.0);
        Ingredient cumin  = new Ingredient("cumin", 1.3, 365, 62.0);
        Ingredient oregano  = new Ingredient("oregano", 1.3, 730, 10.0);
        Ingredient lime  = new Ingredient("lime", 1.3, 14, 90.0);
        Ingredient tomato  = new Ingredient("tomato", 1.3, 7, 200.0);
        Ingredient lettuce  = new Ingredient("lettuce", 1.3, 7, 420.0);
        Ingredient avocado  = new Ingredient("avocado", 1.3, 3, 300.0);
        Ingredient mapleSyrup  = new Ingredient("maple syrup", 1.3, 540, 190.0); // in ml
        Ingredient cauliflower  = new Ingredient("cauliflower", 1.3, 3, 150.0);

        Ingredient bakingPowder  = new Ingredient("baking powder", 1.0, 270, 250.0);

        // TODO: Create ingredient lists and recipe
            // 1 tsp = 10g
            // 1 tbsp = 30 g
            // 1 cloves = 12.5 g (garlic)

        ArrayList<Pair<Ingredient, Double>> ingList = new ArrayList<>();
        // 1 Grilled pork fillet with Asian flavors
        ingList.add(new Pair(outerFilletPork, 200.0));
        ingList.add(new Pair(pakChoi, 35.0));
        ingList.add(new Pair(springOnion, 20.0));
        ingList.add(new Pair(garlic, 25.0));
        ingList.add(new Pair(chili, 15.0));
        ingList.add(new Pair(ginger, 10.0));
        ingList.add(new Pair(coriander,15.0));
        Recipe rec = new Recipe("Grilled pork fillet with Asian flavors", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 2 Beef Satay
        ingList.add(new Pair(ginger, 10.0));
        ingList.add(new Pair(garlic, 50.0));
        ingList.add(new Pair(onion, 60.0));
        ingList.add(new Pair(turmeric, 5.0));
        ingList.add(new Pair(cayennePepper, 1.25));
        ingList.add(new Pair(coriander, 60.0));
        ingList.add(new Pair(lemongrass, 10.0));
        ingList.add(new Pair(beefSirloin, 300.0));
        rec = new Recipe("Beef Satay", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 3 Lemongrass Ground Beef Skewers
        // seems so little, because it's more on seasoning part (eg. salt, sesame oil, etc.)
        ingList.add(new Pair(lemongrass, 30.0));
        ingList.add(new Pair(onion, 150.0));
        ingList.add(new Pair(garlic, 25.0));
        ingList.add(new Pair(beefSirloin, 280.0));
        rec = new Recipe("Beef Satay", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 4 American Potato Salad
        ingList.add(new Pair(potato, 225.0));
        ingList.add(new Pair(egg, 200.0));
        ingList.add(new Pair(onion, 75.0));
        ingList.add(new Pair(springOnion, 10.0));
        ingList.add(new Pair(bellPepper, 20.0));
        ingList.add(new Pair(celery, 45.0));
        ingList.add(new Pair(mayonnaise, 90.0));
        rec = new Recipe("American Potato Salad", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 5 Shrimp Scampi Bake
        ingList.add(new Pair(butter, 110.0));
        ingList.add(new Pair(lemonJuice, 30.0)); //in ml
        ingList.add(new Pair(garlic, 30.0));
        ingList.add(new Pair(shrimp, 320.0));
        rec = new Recipe("Shrimp Scampi Bake", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 6 Chicken Marsala
        ingList.add(new Pair(flour, 60.0));
        ingList.add(new Pair(chickenFillet, 240.0));
        ingList.add(new Pair(butter, 100.0));
        ingList.add(new Pair(mushroom, 75.0));
        ingList.add(new Pair(shallot, 30.0));
        rec = new Recipe("Chicken Marsala", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 7 Pan Seared Salmon
        ingList.add(new Pair(salmonFillet, 170.0));
        ingList.add(new Pair(capers, 30.0));
        ingList.add(new Pair(lemon, 120.0));
        ingList.add(new Pair(mushroom, 75.0));
        ingList.add(new Pair(shallot, 30.0));
        rec = new Recipe("Chicken Marsala", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 8 Lighter Chicken Fettuccine Alfredo
        ingList.add(new Pair(chickenFillet, 240.0));
        ingList.add(new Pair(chickenBroth, 56.0));
        ingList.add(new Pair(garlic, 50.0));
        ingList.add(new Pair(heavyCream, 240.0)); // in ml
        ingList.add(new Pair(egg, 120.0));
        ingList.add(new Pair(fettuccine, 450.0));
        ingList.add(new Pair(parsley, 15.0));
        ingList.add(new Pair(cheese, 125.0));
        rec = new Recipe("Lighter Chicken Fettuccine Alfredo", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 9 Spicy Thai Basil Chicken
        ingList.add(new Pair(chickenFillet, 240.0));
        ingList.add(new Pair(shallot, 25.0));
        ingList.add(new Pair(garlic, 60.0));
        ingList.add(new Pair(chili, 30.0));
        ingList.add(new Pair(basil, 100.0));
        rec = new Recipe("Spicy Thai Basil Chicken", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 10 Roast Chicken with Thyme and Onions
        ingList.add(new Pair(chickenFillet, 300.0));
        ingList.add(new Pair(lemon, 190.0));
        ingList.add(new Pair(onion, 110.0));
        ingList.add(new Pair(shallot, 100.0));
        ingList.add(new Pair(garlic, 150.0));
        ingList.add(new Pair(butter, 110.0));
        ingList.add(new Pair(thyme, 80.0));
        rec = new Recipe("Roast Chicken with Thyme and Onions", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 11 Orange and Milk-Braised Pork Carnitas
        ingList.add(new Pair(outerFilletPork, 350.0));
        ingList.add(new Pair(bayLeaf, 0.3));
        ingList.add(new Pair(cumin, 15.0));
        ingList.add(new Pair(oregano, 1.5));
        ingList.add(new Pair(cayennePepper, 2.0));
        ingList.add(new Pair(orange, 100.0));
        ingList.add(new Pair(milk, 250.0)); // in ml
        rec = new Recipe("Orange and Milk-Braised Pork Carnitas", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 12 Cuban-Style Roast Pork
        ingList.add(new Pair(outerFilletPork, 280.0));
        ingList.add(new Pair(garlic, 50.0));
        ingList.add(new Pair(cumin, 10.0));
        ingList.add(new Pair(oregano, 1.5));
        ingList.add(new Pair(coriander, 10.0));
        ingList.add(new Pair(lime, 90.0));
        ingList.add(new Pair(orange, 100.0));
        rec = new Recipe("Cuban-Style Roast Pork", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 13 Chicken Salad with Bacon, Lettuce, and Tomato
        ingList.add(new Pair(bacon, 140.0));
        ingList.add((new Pair(chickenFillet, 375.0)));
        ingList.add((new Pair(tomato, 120.0)));
        ingList.add((new Pair(celery, 80.0)));
        ingList.add((new Pair(onion, 80.0)));
        ingList.add((new Pair(mayonnaise, 180.0)));
        ingList.add((new Pair(parsley, 15.0)));
        ingList.add((new Pair(lemonJuice, 15.0))); // in ml
        ingList.add((new Pair(lettuce, 160.0)));
        ingList.add((new Pair(avocado, 150.0)));
        rec = new Recipe("Chicken Salad with Bacon, Lettuce, and Tomato", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 14 Southern-Style Buttermilk Fried Chicken
        ingList.add(new Pair(milk, 360.0));
        ingList.add(new Pair(cayennePepper, 15.0));
        ingList.add(new Pair(chickenFillet, 320.0));
        ingList.add(new Pair(flour, 260.0));
        ingList.add(new Pair(bakingPowder, 20.0));
        ingList.add(new Pair(garlic, 30.0));
        ingList.add(new Pair(onion, 30.0));
        rec = new Recipe("Southern-Style Buttermilk Fried Chicken", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 15 Maple Salmon
        ingList.add(new Pair(salmonFillet, 320.0));
        ingList.add(new Pair(mapleSyrup, 50.0));
        ingList.add(new Pair(garlic, 25.0));
        rec = new Recipe("Maple Salmon", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 16 Roasted Garlic Cauliflower
        ingList.add(new Pair(garlic, 30.0));
        ingList.add(new Pair(cauliflower, 320.0));
        ingList.add(new Pair(cheese, 45.0));
        ingList.add(new Pair(parsley, 30.0));
        rec = new Recipe("Roasted Garlic Cauliflower", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 17 Shrimp Verde
        ingList.add(new Pair(garlic, 45.0));
        ingList.add(new Pair(onion, 30.0));
        ingList.add(new Pair(shrimp, 200.0));
        ingList.add(new Pair(parsley, 20.0));
        ingList.add(new Pair(cheese, 30.0));
        rec = new Recipe("Shrimp Verde", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 18 Avocado-Shrimp Salad
        ingList.add(new Pair(avocado, 120.0));
        ingList.add(new Pair(tomato, 100.0));
        ingList.add(new Pair(onion, 60.0));
        ingList.add(new Pair(shrimp, 250.0));
        ingList.add(new Pair(lemonJuice, 30.0)); //in ml
        rec = new Recipe("Avocado-Shrimp Salad", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 19 Baked omelet
        ingList.add(new Pair(egg, 400.0));
        ingList.add(new Pair(milk, 130.0));
        ingList.add(new Pair(ham, 85.0));
        ingList.add(new Pair(cheese, 90.0));
        ingList.add(new Pair(onion, 60.0));
        rec = new Recipe("Baked omelet", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 20 Spaghetti with Bacon
        ingList.add(new Pair(spaghetti, 220.0));
        ingList.add(new Pair(spaghetti, 120.0));
        ingList.add(new Pair(garlic, 50.0));
        ingList.add(new Pair(parsley, 20.0));
        rec = new Recipe("Spaghetti with Bacon", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

    }

}
