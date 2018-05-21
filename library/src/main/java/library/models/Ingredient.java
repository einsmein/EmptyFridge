package library.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient {
    @Id
    private String id;
    private IngredientType type;
    private String name;
    private int wastePenalty;
    private int dayTillExp;
    private float portion;

    public String getId(){
        return id;
    }
    public int getWastePenalty(){
        return wastePenalty;
    }
    public int getDayTillExp(){
        return dayTillExp;
    }
    public float getPortion(){
        return portion;
    }
}

enum IngredientType{

}