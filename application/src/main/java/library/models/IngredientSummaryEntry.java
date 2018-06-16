package library.models;

public class IngredientSummaryEntry {
    public String ingredientName;
    public int piece;
    public double price;
    public double wasteAmount;
    public double wasteScore;

    public IngredientSummaryEntry(String ingName, int piece, double price, double wasteAmount, double wasteScore){
        this.ingredientName = ingName;
        this.piece = piece;
        this.price = price;
        this.wasteAmount = wasteAmount;
        this.wasteScore = wasteScore;
    }

}
