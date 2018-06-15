package library.models;

public class IngredientSummaryEntry {
    public String ingredientName;
    public int piece;
    public double wasteAmount;
    public double wasteScore;

    public IngredientSummaryEntry(String ingName, int piece, double wasteAmount, double wasteScore){
        this.ingredientName = ingName;
        this.piece = piece;
        this.wasteAmount = wasteAmount;
        this.wasteScore = wasteScore;
    }

}
