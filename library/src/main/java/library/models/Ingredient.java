package library.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient {
    @Id
    private String id;
    private IngredientType type;
    private String name;
}

enum IngredientType{

}