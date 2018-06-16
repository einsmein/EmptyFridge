package library.models;

public class IngAndSuggestionResponse {
    public Iterable<IngredientSummaryEntry> ingredientsSummary;
    public Iterable<SuggestionSummary> suggestionList;
    public double totalWaste;
    public double totalPrice;
}
