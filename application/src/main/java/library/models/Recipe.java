package library.models;

import javafx.util.Pair;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Recipe {
    @Id private String id;
    @UniqueElements protected String name;
    protected ArrayList<Pair<Ingredient,Double>> ingAmount = new ArrayList<>();

    public Recipe(String name, ArrayList<Pair<Ingredient,Double>> ingAmount ){
        this.name = name;
        this.ingAmount = ingAmount;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Iterable<Pair<Ingredient,Double>> getIngredientsAmount(){
        return ingAmount;
    }
    public void addIngredients(Iterable<Pair<Ingredient,Double>> ingAmount){
        ingAmount.forEach(ing -> this.ingAmount.add(ing));
    }

    public void addIngredient(Ingredient ingredient, int amount){
        this.ingAmount.add(new Pair(ingredient, amount));
    }
}
