package library.models;

public class IngredientSummary {
//    public Ingredient ingredient;
    public int piece;
    public double wasteAmount;
    public double wasteScore;

    public IngredientSummary(int piece, double wasteAmount, double wasteScore){
//        this.ingredient = ing;
        this.piece = piece;
        this.wasteAmount = wasteAmount;
        this.wasteScore = wasteScore;
    }
}
