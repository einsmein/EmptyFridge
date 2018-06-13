package library.models;

public class IngSummaryInfo {
//    public Ingredient ingredient;
    public int piece;
    public double wasteAmount;
    public double wasteScore;

    public IngSummaryInfo(int piece, double wasteAmount, double wasteScore){
//        this.ingredient = ing;
        this.piece = piece;
        this.wasteAmount = wasteAmount;
        this.wasteScore = wasteScore;
    }
}
