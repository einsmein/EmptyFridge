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
import java.util.Arrays;

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
        // Ingredient pork = new Ingredient("pork", 2.0, 5, 235.0, );
        Ingredient outerFilletPork = new Ingredient("outer fillet pork", 2.0, 5, 730.0, 109.00);
        Ingredient beefSirloin = new Ingredient("beef sirloin", 2.0, 5, 365.0, 119.90);
        Ingredient shrimp = new Ingredient("shrimp", 2.0, 7, 200.0, 44.00);
        Ingredient chickenFillet = new Ingredient("chicken fillet", 2.0, 5, 200.0, 130.90);
        Ingredient salmonFillet = new Ingredient("salmon fillet", 2.0, 3, 200.0, 82.30);
        Ingredient bacon = new Ingredient("bacon", 2.0, 7, 200.0, 40.30);
        Ingredient ham = new Ingredient("ham", 2.0, 7, 100.0, 15.00);

        Ingredient potato = new Ingredient("potato", 1.8, 21, 1000.0, 24.90);
        Ingredient mushroom = new Ingredient("mushroom", 1.8, 5, 250.0, 8.72);
        Ingredient egg = new Ingredient("egg", 1.8, 7, 800.0, 39.90);
        Ingredient mayonnaise = new Ingredient("mayonnaise", 1.8, 60, 160.0, 19.00);
        Ingredient butter = new Ingredient("butter", 1.8, 180, 250.0, 28.90);
        Ingredient flour = new Ingredient("flour", 1.8, 365, 1000.0, 9.80);
        Ingredient heavyCream = new Ingredient("heavy cream", 1.8, 6, 300.0, 19.70); // 300 in ml
        Ingredient fettuccine = new Ingredient("fettuccine", 1.8, 365, 500.0, 24.30);
        Ingredient spaghetti = new Ingredient("spaghetti", 1.8, 365, 500.0, 21.70);
        Ingredient cheese = new Ingredient("cheese", 1.8, 60, 300.0, 47.30);
        Ingredient milk = new Ingredient("milk", 1.8, 6, 1000.0, 17.10); // in ml
        //Ingredient rice = new Ingredient("rice", 1.8, 180, 1000);

        Ingredient chili = new Ingredient("chili", 1.3, 4, 50.0, 23.90);
        Ingredient coriander = new Ingredient("coriander", 1.3, 5, 20.0, 23.40);
        Ingredient garlic = new Ingredient("garlic", 1.3, 120, 100.0, 14.60);
        Ingredient ginger = new Ingredient("ginger", 1.3, 30, 100.0, 13.80);
        Ingredient pakChoi = new Ingredient("pak choi", 1.3, 7, 125.0, 14.90);
        Ingredient springOnion = new Ingredient("spring onion", 1.3, 7, 150.0, 14.90);
        Ingredient onion = new Ingredient("onion", 1.3, 30, 630.0, 16.40);
        Ingredient turmeric = new Ingredient("turmeric", 1.3, 365, 70.0, 37.90);
        Ingredient cayennePepper = new Ingredient("cayenne pepper", 1.3, 365, 62.0, 37.70);
        Ingredient lemongrass = new Ingredient("lemongrass", 1.3, 14, 50.0, 24.90);
        Ingredient bellPepper = new Ingredient("bell pepper", 1.3, 14, 260.0, 15.00);
        Ingredient shallot = new Ingredient("shallot", 1.3, 14, 200.0, 14.20);
        Ingredient capers = new Ingredient("capers", 1.3, 365, 100.0, 28.40);
        Ingredient celery = new Ingredient("celery", 1.3, 14, 500.0, 29.90);
        Ingredient lemon = new Ingredient("lemon", 1.3, 14, 380.0, 13.64);
        Ingredient orange = new Ingredient("orange", 1.3, 10, 320.0, 5.52);
        Ingredient lemonJuice = new Ingredient("lemon juice", 1.3, 120, 250.0, 19.30); // 250 in ml
        Ingredient chickenBroth = new Ingredient("chicken broth", 1.3, 180, 112.0,23.90);
        Ingredient parsley  = new Ingredient("parsley", 1.3, 14, 20.0, 23.40);
        Ingredient basil  = new Ingredient("basil", 1.3, 5, 20.0, 23.40);
        Ingredient thyme  = new Ingredient("thyme", 1.3, 7, 20.0, 23.40);
        Ingredient bayLeaf  = new Ingredient("bay leaf", 1.3, 365, 2.0, 7.20);
        Ingredient cumin  = new Ingredient("cumin", 1.3, 365, 62.0, 31.70);
        Ingredient oregano  = new Ingredient("oregano", 1.3, 730, 10.0, 21.20);
        Ingredient lime  = new Ingredient("lime", 1.3, 14, 90.0, 3.00);
        Ingredient tomato  = new Ingredient("tomato", 1.3, 7, 200.0, 39.90);
        Ingredient lettuce  = new Ingredient("lettuce", 1.3, 7, 420.0, 19.90);
        Ingredient avocado  = new Ingredient("avocado", 1.3, 3, 300.0, 27.90);
        Ingredient mapleSyrup  = new Ingredient("maple syrup", 1.3, 540, 190.0, 74.20); // in ml
        Ingredient cauliflower  = new Ingredient("cauliflower", 1.3, 3, 150.0, 24.90);
        Ingredient bakingPowder  = new Ingredient("baking powder", 1.0, 270, 250.0, 28.80);

        ingredientRepo.insert(Arrays.asList(outerFilletPork, beefSirloin, shrimp, chickenFillet, salmonFillet, bacon, ham, potato,mushroom, egg,
                mayonnaise, butter, flour, heavyCream, fettuccine, spaghetti, cheese, milk, chili, coriander, garlic, ginger, pakChoi, springOnion,
                onion, turmeric, cayennePepper, lemongrass, bellPepper, shallot, capers, celery, lemon, orange, lemonJuice, chickenBroth,
                parsley, basil, thyme, bayLeaf, cumin, oregano, lime, tomato, lettuce, avocado, mapleSyrup, cauliflower, bakingPowder));


        // TODO: Create ingredient lists and recipe
            // 1 tsp = 10g
            // 1 tbsp = 30 g
            // 1 cloves = 12.5 g (garlic)

        ArrayList<Pair<String, Double>> ingList = new ArrayList<>();
        Recipe rec;

        // 1 Grilled pork fillet with Asian flavors
        ingList.add(Pair.of(outerFilletPork.getName(), 200.0));
        ingList.add(Pair.of(pakChoi.getName(), 35.0));
        ingList.add(Pair.of(springOnion.getName(), 20.0));
        ingList.add(Pair.of(garlic.getName(), 25.0));
        ingList.add(Pair.of(chili.getName(), 15.0));
        ingList.add(Pair.of(ginger.getName(), 10.0));
        ingList.add(Pair.of(coriander.getName(),15.0));
        rec = new Recipe("Grilled pork fillet with Asian flavors", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 2 Beef Satay
        ingList.add(Pair.of(ginger.getName(), 10.0));
        ingList.add(Pair.of(garlic.getName(), 50.0));
        ingList.add(Pair.of(onion.getName(), 60.0));
        ingList.add(Pair.of(turmeric.getName(), 5.0));
        ingList.add(Pair.of(cayennePepper.getName(), 1.25));
        ingList.add(Pair.of(coriander.getName(), 60.0));
        ingList.add(Pair.of(lemongrass.getName(), 10.0));
        ingList.add(Pair.of(beefSirloin.getName(), 300.0));
        rec = new Recipe("Beef Satay", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 3 Lemongrass Ground Beef Skewers
        // seems so little, because it's more on seasoning part (eg. salt, sesame oil, etc.)
        ingList.add(Pair.of(lemongrass.getName(), 30.0));
        ingList.add(Pair.of(onion.getName(), 150.0));
        ingList.add(Pair.of(garlic.getName(), 25.0));
        ingList.add(Pair.of(beefSirloin.getName(), 280.0));
        rec = new Recipe("Lemongrass Ground Beef Skewers", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 4 American Potato Salad
        ingList.add(Pair.of(potato.getName(), 225.0));
        ingList.add(Pair.of(egg.getName(), 200.0));
        ingList.add(Pair.of(onion.getName(), 75.0));
        ingList.add(Pair.of(springOnion.getName(), 10.0));
        ingList.add(Pair.of(bellPepper.getName(), 20.0));
        ingList.add(Pair.of(celery.getName(), 45.0));
        ingList.add(Pair.of(mayonnaise.getName(), 90.0));
        rec = new Recipe("American Potato Salad", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 5 Shrimp Scampi Bake
        ingList.add(Pair.of(butter.getName(), 110.0));
        ingList.add(Pair.of(lemonJuice.getName(), 30.0)); //in ml
        ingList.add(Pair.of(garlic.getName(), 30.0));
        ingList.add(Pair.of(shrimp.getName(), 320.0));
        rec = new Recipe("Shrimp Scampi Bake", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 6 Chicken Marsala
        ingList.add(Pair.of(flour.getName(), 60.0));
        ingList.add(Pair.of(chickenFillet.getName(), 240.0));
        ingList.add(Pair.of(butter.getName(), 100.0));
        ingList.add(Pair.of(mushroom.getName(), 75.0));
        ingList.add(Pair.of(shallot.getName(), 30.0));
        rec = new Recipe("Chicken Marsala", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 7 Pan Seared Salmon
        ingList.add(Pair.of(salmonFillet.getName(), 170.0));
        ingList.add(Pair.of(capers.getName(), 30.0));
        ingList.add(Pair.of(lemon.getName(), 120.0));
        ingList.add(Pair.of(mushroom.getName(), 75.0));
        ingList.add(Pair.of(shallot.getName(), 30.0));
        rec = new Recipe("Pan Seared Salmon", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 8 Lighter Chicken Fettuccine Alfredo
        ingList.add(Pair.of(chickenFillet.getName(), 240.0));
        ingList.add(Pair.of(chickenBroth.getName(), 56.0));
        ingList.add(Pair.of(garlic.getName(), 50.0));
        ingList.add(Pair.of(heavyCream.getName(), 240.0)); // in ml
        ingList.add(Pair.of(egg.getName(), 120.0));
        ingList.add(Pair.of(fettuccine.getName(), 450.0));
        ingList.add(Pair.of(parsley.getName(), 15.0));
        ingList.add(Pair.of(cheese.getName(), 125.0));
        rec = new Recipe("Lighter Chicken Fettuccine Alfredo", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 9 Spicy Thai Basil Chicken
        ingList.add(Pair.of(chickenFillet.getName(), 240.0));
        ingList.add(Pair.of(shallot.getName(), 25.0));
        ingList.add(Pair.of(garlic.getName(), 60.0));
        ingList.add(Pair.of(chili.getName(), 30.0));
        ingList.add(Pair.of(basil.getName(), 100.0));
        rec = new Recipe("Spicy Thai Basil Chicken", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 10 Roast Chicken with Thyme and Onions
        ingList.add(Pair.of(chickenFillet.getName(), 300.0));
        ingList.add(Pair.of(lemon.getName(), 190.0));
        ingList.add(Pair.of(onion.getName(), 110.0));
        ingList.add(Pair.of(shallot.getName(), 100.0));
        ingList.add(Pair.of(garlic.getName(), 150.0));
        ingList.add(Pair.of(butter.getName(), 110.0));
        ingList.add(Pair.of(thyme.getName(), 80.0));
        rec = new Recipe("Roast Chicken with Thyme and Onions", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 11 Orange and Milk-Braised Pork Carnitas
        ingList.add(Pair.of(outerFilletPork.getName(), 350.0));
        ingList.add(Pair.of(bayLeaf.getName(), 0.3));
        ingList.add(Pair.of(cumin.getName(), 15.0));
        ingList.add(Pair.of(oregano.getName(), 1.5));
        ingList.add(Pair.of(cayennePepper.getName(), 2.0));
        ingList.add(Pair.of(orange.getName(), 100.0));
        ingList.add(Pair.of(milk.getName(), 250.0)); // in ml
        rec = new Recipe("Orange and Milk-Braised Pork Carnitas", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 12 Cuban-Style Roast Pork
        ingList.add(Pair.of(outerFilletPork.getName(), 280.0));
        ingList.add(Pair.of(garlic.getName(), 50.0));
        ingList.add(Pair.of(cumin.getName(), 10.0));
        ingList.add(Pair.of(oregano.getName(), 1.5));
        ingList.add(Pair.of(coriander.getName(), 10.0));
        ingList.add(Pair.of(lime.getName(), 90.0));
        ingList.add(Pair.of(orange.getName(), 100.0));
        rec = new Recipe("Cuban-Style Roast Pork", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 13 Chicken Salad with Bacon, Lettuce, and Tomato
        ingList.add(Pair.of(bacon.getName(), 140.0));
        ingList.add(Pair.of(chickenFillet.getName(), 375.0));
        ingList.add(Pair.of(tomato.getName(), 120.0));
        ingList.add(Pair.of(celery.getName(), 80.0));
        ingList.add(Pair.of(onion.getName(), 80.0));
        ingList.add(Pair.of(mayonnaise.getName(), 180.0));
        ingList.add(Pair.of(parsley.getName(), 15.0));
        ingList.add(Pair.of(lemonJuice.getName(), 15.0)); // in ml
        ingList.add(Pair.of(lettuce.getName(), 160.0));
        ingList.add(Pair.of(avocado.getName(), 150.0));
        rec = new Recipe("Chicken Salad with Bacon, Lettuce, and Tomato", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 14 Southern-Style Buttermilk Fried Chicken
        ingList.add(Pair.of(milk.getName(), 360.0));
        ingList.add(Pair.of(cayennePepper.getName(), 15.0));
        ingList.add(Pair.of(chickenFillet.getName(), 320.0));
        ingList.add(Pair.of(flour.getName(), 260.0));
        ingList.add(Pair.of(bakingPowder.getName(), 20.0));
        ingList.add(Pair.of(garlic.getName(), 30.0));
        ingList.add(Pair.of(onion.getName(), 30.0));
        rec = new Recipe("Southern-Style Buttermilk Fried Chicken", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 15 Maple Salmon
        ingList.add(Pair.of(salmonFillet.getName(), 320.0));
        ingList.add(Pair.of(mapleSyrup.getName(), 50.0));
        ingList.add(Pair.of(garlic.getName(), 25.0));
        rec = new Recipe("Maple Salmon", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 16 Roasted Garlic Cauliflower
        ingList.add(Pair.of(garlic.getName(), 30.0));
        ingList.add(Pair.of(cauliflower.getName(), 320.0));
        ingList.add(Pair.of(cheese.getName(), 45.0));
        ingList.add(Pair.of(parsley.getName(), 30.0));
        rec = new Recipe("Roasted Garlic Cauliflower", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 17 Shrimp Verde
        ingList.add(Pair.of(garlic.getName(), 45.0));
        ingList.add(Pair.of(onion.getName(), 30.0));
        ingList.add(Pair.of(shrimp.getName(), 200.0));
        ingList.add(Pair.of(parsley.getName(), 20.0));
        ingList.add(Pair.of(cheese.getName(), 30.0));
        rec = new Recipe("Shrimp Verde", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 18 Avocado-Shrimp Salad
        ingList.add(Pair.of(avocado.getName(), 120.0));
        ingList.add(Pair.of(tomato.getName(), 100.0));
        ingList.add(Pair.of(onion.getName(), 60.0));
        ingList.add(Pair.of(shrimp.getName(), 250.0));
        ingList.add(Pair.of(lemonJuice.getName(), 30.0)); //in ml
        rec = new Recipe("Avocado-Shrimp Salad", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 19 Baked omelet
        ingList.add(Pair.of(egg.getName(), 400.0));
        ingList.add(Pair.of(milk.getName(), 130.0));
        ingList.add(Pair.of(ham.getName(), 85.0));
        ingList.add(Pair.of(cheese.getName(), 90.0));
        ingList.add(Pair.of(onion.getName(), 60.0));
        rec = new Recipe("Baked omelet", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        // 20 Spaghetti with Bacon
        ingList.add(Pair.of(spaghetti.getName(), 220.0));
        ingList.add(Pair.of(bacon.getName(), 120.0));
        ingList.add(Pair.of(garlic.getName(), 50.0));
        ingList.add(Pair.of(parsley.getName(), 20.0));
        rec = new Recipe("Spaghetti with Bacon", ingList);
        recipeRepo.insert(rec);
        ingList.clear();


        //addTest();

    }

    // Testing
    public void addTest(){
        ArrayList<Pair<String, Double>> ingList = new ArrayList<>();
        Recipe rec;

        Ingredient a = new Ingredient("A", 1, 3, 20, 2);
        Ingredient b = new Ingredient("B", 1, 3, 30, 3);
        Ingredient c = new Ingredient("C", 1, 3, 20, 4);
        Ingredient d = new Ingredient("D", 1, 5, 10, 1);
        Ingredient e = new Ingredient("E", 2, 7, 20, 1);
        Ingredient f = new Ingredient("F", 5, 3, 30, 2);
        Ingredient g = new Ingredient("G", 2, 5, 20, 0.5);
        ingredientRepo.insert(Arrays.asList(a, b, c, d, e, f, g));

        ingList.add(Pair.of(a.getName(), 4.0));
        ingList.add(Pair.of(b.getName(), 3.0));
        rec = new Recipe("X1", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        ingList.add(Pair.of(a.getName(), 12.0));
        ingList.add(Pair.of(c.getName(), 2.0));
        ingList.add(Pair.of(d.getName(), 3.0));
        ingList.add(Pair.of(e.getName(), 10.0));
        ingList.add(Pair.of(f.getName(), 20.0));
        ingList.add(Pair.of(g.getName(), 5.0));
        rec = new Recipe("X2", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        ingList.add(Pair.of(b.getName(), 14.0));
        ingList.add(Pair.of(d.getName(), 3.0));
        ingList.add(Pair.of(e.getName(), 5.0));
        ingList.add(Pair.of(f.getName(), 4.0));
        ingList.add(Pair.of(g.getName(), 12.0));
        rec = new Recipe("X3", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        ingList.add(Pair.of(c.getName(), 15.0));
        ingList.add(Pair.of(d.getName(), 5.0));
        ingList.add(Pair.of(e.getName(), 3.0));
        ingList.add(Pair.of(f.getName(), 2.0));
        ingList.add(Pair.of(g.getName(), 2.0));
        rec = new Recipe("X4", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        ingList.add(Pair.of(a.getName(), 2.0));
        ingList.add(Pair.of(b.getName(), 9.0));
        ingList.add(Pair.of(e.getName(), 2.0));
        ingList.add(Pair.of(f.getName(), 3.0));
        ingList.add(Pair.of(g.getName(), 4.0));
        rec = new Recipe("X5", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

        ingList.add(Pair.of(a.getName(), 8.0));
        ingList.add(Pair.of(c.getName(), 18.0));
        ingList.add(Pair.of(d.getName(), 7.0));
        ingList.add(Pair.of(e.getName(), 8.0));
        ingList.add(Pair.of(f.getName(), 40.0));
        ingList.add(Pair.of(g.getName(), 14.0));
        rec = new Recipe("X6", ingList);
        recipeRepo.insert(rec);
        ingList.clear();

//        ingList.add(Pair.of(pork, 200.0));
//        rec = new Recipe("Test Menu Pork Base", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//        ingList.add(Pair.of(pork, 40.0));
//        rec = new Recipe("Test Menu Pork 40 (Bad comb)", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//
//        ingList.add(Pair.of(pork, 35.0));
//        rec = new Recipe("Test Menu Pork 35 (Best sub)", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
//
//
//        ingList.add(Pair.of(pork, 200.0));
//        rec = new Recipe("Test Menu Pork 70 (2nd Best sub)", ingList);
//        recipeRepo.insert(rec);
//        ingList.clear();
    }

}
