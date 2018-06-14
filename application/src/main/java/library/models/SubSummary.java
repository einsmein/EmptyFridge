package library.models;

public class SubSummary implements Comparable<SubSummary>{
    public Recipe oldRecipe;
    public Recipe newRecipe;
    public IngAmountCollection diffAmountCollection;
//    public IngAmountCollection diffScoreCollection;
    public double diffWasteScore;

    public SubSummary(Recipe oldRecipe, Recipe newRecipe, IngAmountCollection diffAmount, double diffWasteScore){
        this.oldRecipe = oldRecipe;
        this.newRecipe = newRecipe;
        this.diffAmountCollection = diffAmount;
        this.diffWasteScore = diffWasteScore;
    }

    public boolean hasLowerWaste(SubSummary s){
//        return this.diffWasteScore < s.diffWasteScore;
        return this.compareTo(s) < 0;
    }

    @Override
    public int compareTo(SubSummary s) {
        return Double.compare(diffWasteScore, s.diffWasteScore);
    }
}
