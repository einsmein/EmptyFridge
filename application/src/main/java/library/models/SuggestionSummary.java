package library.models;

import java.util.List;

public class SuggestionSummary implements Comparable<SuggestionSummary>{
    public Recipe oldRecipe;
    public Recipe newRecipe;
    public List<IngredientAmountEntry> diffAmountCollection;
//    public IngredientAmountMap diffScoreCollection;
    public double diffWasteScore;

    public SuggestionSummary(Recipe oldRecipe, Recipe newRecipe, List<IngredientAmountEntry> diffAmount, double diffWasteScore){
        this.oldRecipe = oldRecipe;
        this.newRecipe = newRecipe;
        this.diffAmountCollection = diffAmount;
        this.diffWasteScore = diffWasteScore;
    }

    public boolean hasLowerWaste(SuggestionSummary s){
//        return this.diffWasteScore < s.diffWasteScore;
        return this.compareTo(s) < 0;
    }

    @Override
    public int compareTo(SuggestionSummary s) {
        return Double.compare(diffWasteScore, s.diffWasteScore);
    }
}
