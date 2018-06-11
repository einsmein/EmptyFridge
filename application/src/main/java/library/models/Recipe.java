package library.models;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.util.Pair;

import java.util.ArrayList;

@Document
public class Recipe {
    @Id private String id;
    @UniqueElements protected String name;
    protected ArrayList<Pair<Ingredient,Double>> ingAmount;

    public Recipe(String name, ArrayList<Pair<Ingredient,Double>> ingAmount){
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

    public void addIngredient(Ingredient ingredient, double amount){
        this.ingAmount.add(Pair.of(ingredient, amount));
    }
}
