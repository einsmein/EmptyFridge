package library.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.*;

public class IngredientSummaryMap implements Serializable {
    private ObjectMapper mapper = new ObjectMapper();
    Map<String, IngredientSummary> map = new HashMap<>();
    double wasteScore = 0;
    double price = 0;

    public void add(String ingredientName, IngredientSummary summary){
        map.put(ingredientName, summary);
        wasteScore += summary.wasteScore;
        price += summary.price;
    }

    public boolean has(String ingredientName){
        return map.containsKey(ingredientName);
    }

    public void update(String ingredientName, IngredientSummary summary){
        if (this.has(ingredientName)) {
            wasteScore += summary.wasteScore - map.get(ingredientName).wasteScore;
            map.replace(ingredientName, summary);
        } else {
            add(ingredientName, summary);
        }
    }

    public IngredientSummary getSummary(String ingName){
        if(!map.containsKey(ingName))
            return null;
        return map.get(ingName);
    }

    public Set<String> getIngredientSet(){
        return map.keySet();
    }

    public double getWasteScore(){
        return wasteScore;
    }

    public double getPrice() {return price;}

    public List<IngredientSummaryEntry> getIngredientSummaryEntries(){
        ArrayList<IngredientSummaryEntry> entries = new ArrayList<>();
        for(Map.Entry<String, IngredientSummary> entry : map.entrySet()){
            entries.add(new IngredientSummaryEntry(entry.getKey(), entry.getValue().piece, entry.getValue().wasteAmount, entry.getValue().wasteScore));
        }
        return entries;
    }

    @Override
    public String toString(){
        try {
            return mapper.writeValueAsString(map);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
