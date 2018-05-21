package library.models;

import javafx.util.Pair;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document
public class Recipe {
    @Id private String id;
    @UniqueElements private String name;
    private ArrayList<Pair<Ingredient,Double>> ingAmount = new ArrayList<>();

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
