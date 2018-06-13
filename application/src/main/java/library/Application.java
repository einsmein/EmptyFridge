package library;

import library.models.Ingredient;
import library.models.Recipe;
import library.repository.IngredientRepository;
import library.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.util.Pair;

import java.util.ArrayList;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    RecipeRepository recipeRepo;
    @Autowired
    IngredientRepository ingredientRepo;

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        // Clean repo
        recipeRepo.deleteAll();
        ingredientRepo.deleteAll();

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
        ingredientRepo.save(pork);

        // TODO: Create ingredient lists and recipe
            // 1 tsp = 10g
            // 1 tbsp = 30 g
            // 1 cloves = 12.5 g (garlic)

        ArrayList<Pair<Ingredient, Double>> ingList = new ArrayList<>();
        Recipe rec;

//        // 1 Grilled pork fillet with Asian flavors
//        ingList.add(Pair.of(outerFilletPork, 200.0));
//        ingList.add(Pair.of(pakChoi, 35.0));
//        ingList.add(Pair.of(springOnion, 20.0));
//        ingList.add(Pair.of(garlic, 25.0));
//        ingList.add(Pair.of(chili, 15.0));
//        ingList.add(Pair.of(ginger, 10.0));
//        ingList.add(Pair.of(coriander,15.0));
//        rec = new Recipe("Grilled pork fillet with Asian flavors", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 2 Beef Satay
//        ingList.add(Pair.of(ginger, 10.0));
//        ingList.add(Pair.of(garlic, 50.0));
//        ingList.add(Pair.of(onion, 60.0));
//        ingList.add(Pair.of(turmeric, 5.0));
//        ingList.add(Pair.of(cayennePepper, 1.25));
//        ingList.add(Pair.of(coriander, 60.0));
//        ingList.add(Pair.of(lemongrass, 10.0));
//        ingList.add(Pair.of(beefSirloin, 300.0));
//        rec = new Recipe("Beef Satay", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 3 Lemongrass Ground Beef Skewers
//        // seems so little, because it's more on seasoning part (eg. salt, sesame oil, etc.)
//        ingList.add(Pair.of(lemongrass, 30.0));
//        ingList.add(Pair.of(onion, 150.0));
//        ingList.add(Pair.of(garlic, 25.0));
//        ingList.add(Pair.of(beefSirloin, 280.0));
//        rec = new Recipe("Beef Satay", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 4 American Potato Salad
//        ingList.add(Pair.of(potato, 225.0));
//        ingList.add(Pair.of(egg, 200.0));
//        ingList.add(Pair.of(onion, 75.0));
//        ingList.add(Pair.of(springOnion, 10.0));
//        ingList.add(Pair.of(bellPepper, 20.0));
//        ingList.add(Pair.of(celery, 45.0));
//        ingList.add(Pair.of(mayonnaise, 90.0));
//        rec = new Recipe("American Potato Salad", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 5 Shrimp Scampi Bake
//        ingList.add(Pair.of(butter, 110.0));
//        ingList.add(Pair.of(lemonJuice, 30.0)); //in ml
//        ingList.add(Pair.of(garlic, 30.0));
//        ingList.add(Pair.of(shrimp, 320.0));
//        rec = new Recipe("Shrimp Scampi Bake", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 6 Chicken Marsala
//        ingList.add(Pair.of(flour, 60.0));
//        ingList.add(Pair.of(chickenFillet, 240.0));
//        ingList.add(Pair.of(butter, 100.0));
//        ingList.add(Pair.of(mushroom, 75.0));
//        ingList.add(Pair.of(shallot, 30.0));
//        rec = new Recipe("Chicken Marsala", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 7 Pan Seared Salmon
//        ingList.add(Pair.of(salmonFillet, 170.0));
//        ingList.add(Pair.of(capers, 30.0));
//        ingList.add(Pair.of(lemon, 120.0));
//        ingList.add(Pair.of(mushroom, 75.0));
//        ingList.add(Pair.of(shallot, 30.0));
//        rec = new Recipe("Chicken Marsala", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 8 Lighter Chicken Fettuccine Alfredo
//        ingList.add(Pair.of(chickenFillet, 240.0));
//        ingList.add(Pair.of(chickenBroth, 56.0));
//        ingList.add(Pair.of(garlic, 50.0));
//        ingList.add(Pair.of(heavyCream, 240.0)); // in ml
//        ingList.add(Pair.of(egg, 120.0));
//        ingList.add(Pair.of(fettuccine, 450.0));
//        ingList.add(Pair.of(parsley, 15.0));
//        ingList.add(Pair.of(cheese, 125.0));
//        rec = new Recipe("Lighter Chicken Fettuccine Alfredo", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 9 Spicy Thai Basil Chicken
//        ingList.add(Pair.of(chickenFillet, 240.0));
//        ingList.add(Pair.of(shallot, 25.0));
//        ingList.add(Pair.of(garlic, 60.0));
//        ingList.add(Pair.of(chili, 30.0));
//        ingList.add(Pair.of(basil, 100.0));
//        rec = new Recipe("Spicy Thai Basil Chicken", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 10 Roast Chicken with Thyme and Onions
//        ingList.add(Pair.of(chickenFillet, 300.0));
//        ingList.add(Pair.of(lemon, 190.0));
//        ingList.add(Pair.of(onion, 110.0));
//        ingList.add(Pair.of(shallot, 100.0));
//        ingList.add(Pair.of(garlic, 150.0));
//        ingList.add(Pair.of(butter, 110.0));
//        ingList.add(Pair.of(thyme, 80.0));
//        rec = new Recipe("Roast Chicken with Thyme and Onions", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 11 Orange and Milk-Braised Pork Carnitas
//        ingList.add(Pair.of(outerFilletPork, 350.0));
//        ingList.add(Pair.of(bayLeaf, 0.3));
//        ingList.add(Pair.of(cumin, 15.0));
//        ingList.add(Pair.of(oregano, 1.5));
//        ingList.add(Pair.of(cayennePepper, 2.0));
//        ingList.add(Pair.of(orange, 100.0));
//        ingList.add(Pair.of(milk, 250.0)); // in ml
//        rec = new Recipe("Orange and Milk-Braised Pork Carnitas", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 12 Cuban-Style Roast Pork
//        ingList.add(Pair.of(outerFilletPork, 280.0));
//        ingList.add(Pair.of(garlic, 50.0));
//        ingList.add(Pair.of(cumin, 10.0));
//        ingList.add(Pair.of(oregano, 1.5));
//        ingList.add(Pair.of(coriander, 10.0));
//        ingList.add(Pair.of(lime, 90.0));
//        ingList.add(Pair.of(orange, 100.0));
//        rec = new Recipe("Cuban-Style Roast Pork", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 13 Chicken Salad with Bacon, Lettuce, and Tomato
//        ingList.add(Pair.of(bacon, 140.0));
//        ingList.add(Pair.of(chickenFillet, 375.0));
//        ingList.add(Pair.of(tomato, 120.0));
//        ingList.add(Pair.of(celery, 80.0));
//        ingList.add(Pair.of(onion, 80.0));
//        ingList.add(Pair.of(mayonnaise, 180.0));
//        ingList.add(Pair.of(parsley, 15.0));
//        ingList.add(Pair.of(lemonJuice, 15.0)); // in ml
//        ingList.add(Pair.of(lettuce, 160.0));
//        ingList.add(Pair.of(avocado, 150.0));
//        rec = new Recipe("Chicken Salad with Bacon, Lettuce, and Tomato", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 14 Southern-Style Buttermilk Fried Chicken
//        ingList.add(Pair.of(milk, 360.0));
//        ingList.add(Pair.of(cayennePepper, 15.0));
//        ingList.add(Pair.of(chickenFillet, 320.0));
//        ingList.add(Pair.of(flour, 260.0));
//        ingList.add(Pair.of(bakingPowder, 20.0));
//        ingList.add(Pair.of(garlic, 30.0));
//        ingList.add(Pair.of(onion, 30.0));
//        rec = new Recipe("Southern-Style Buttermilk Fried Chicken", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 15 Maple Salmon
//        ingList.add(Pair.of(salmonFillet, 320.0));
//        ingList.add(Pair.of(mapleSyrup, 50.0));
//        ingList.add(Pair.of(garlic, 25.0));
//        rec = new Recipe("Maple Salmon", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 16 Roasted Garlic Cauliflower
//        ingList.add(Pair.of(garlic, 30.0));
//        ingList.add(Pair.of(cauliflower, 320.0));
//        ingList.add(Pair.of(cheese, 45.0));
//        ingList.add(Pair.of(parsley, 30.0));
//        rec = new Recipe("Roasted Garlic Cauliflower", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 17 Shrimp Verde
//        ingList.add(Pair.of(garlic, 45.0));
//        ingList.add(Pair.of(onion, 30.0));
//        ingList.add(Pair.of(shrimp, 200.0));
//        ingList.add(Pair.of(parsley, 20.0));
//        ingList.add(Pair.of(cheese, 30.0));
//        rec = new Recipe("Shrimp Verde", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 18 Avocado-Shrimp Salad
//        ingList.add(Pair.of(avocado, 120.0));
//        ingList.add(Pair.of(tomato, 100.0));
//        ingList.add(Pair.of(onion, 60.0));
//        ingList.add(Pair.of(shrimp, 250.0));
//        ingList.add(Pair.of(lemonJuice, 30.0)); //in ml
//        rec = new Recipe("Avocado-Shrimp Salad", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 19 Baked omelet
//        ingList.add(Pair.of(egg, 400.0));
//        ingList.add(Pair.of(milk, 130.0));
//        ingList.add(Pair.of(ham, 85.0));
//        ingList.add(Pair.of(cheese, 90.0));
//        ingList.add(Pair.of(onion, 60.0));
//        rec = new Recipe("Baked omelet", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        // 20 Spaghetti with Bacon
//        ingList.add(Pair.of(spaghetti, 220.0));
//        ingList.add(Pair.of(spaghetti, 120.0));
//        ingList.add(Pair.of(garlic, 50.0));
//        ingList.add(Pair.of(parsley, 20.0));
//        rec = new Recipe("Spaghetti with Bacon", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();


        ingList.add(Pair.of(pork, 200.0));
        rec = new Recipe("Test Menu Pork Base", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        ingList.add(Pair.of(pork, 40.0));
        rec = new Recipe("Test Menu Pork 40 (Bad comb)", ingList);
        recipeRepo.insert(rec);
        ingList.clear();


        ingList.add(Pair.of(pork, 35.0));
        rec = new Recipe("Test Menu Pork 35 (Best sub)", ingList);
        recipeRepo.insert(rec);
        ingList.clear();


        ingList.add(Pair.of(pork, 200.0));
        rec = new Recipe("Test Menu Pork 70 (2nd Best sub)", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

    }

}
