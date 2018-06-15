package library.models;

public class IngredientSummary {
//    public Ingredient ingredient;
    public int piece;
    public double price;
    public double wasteAmount;
    public double wasteScore;

    public IngredientSummary(int piece, double price, double wasteAmount, double wasteScore){
//        this.ingredient = ing;
        this.piece = piece;
        this.price = price;
        this.wasteAmount = wasteAmount;
        this.wasteScore = wasteScore;
    }
}
