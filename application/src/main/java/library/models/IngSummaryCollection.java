package library.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IngSummaryCollection implements Serializable {
        private ObjectMapper mapper = new ObjectMapper();
        Map<String, IngSummaryInfo> collection = new HashMap<>();
        double wasteScore = 0;

        public void add(String ingredientName, IngSummaryInfo summary){
            collection.put(ingredientName, summary);
            wasteScore += summary.wasteScore;
        }

        public boolean has(String ingredientName){
            return collection.containsKey(ingredientName);
        }

        public void update(String ingredientName, IngSummaryInfo summary){
        if (this.has(ingredientName)) {
            wasteScore += summary.wasteScore - collection.get(ingredientName).wasteScore;
            collection.replace(ingredientName, summary);
        } else {
            add(ingredientName, summary);
        }
    }

    public Set<String> getIngredientSet(){
        return collection.keySet();
    }

    public double getWasteScore(){
        return wasteScore;
    }

    @Override
    public String toString(){
        try {
            return mapper.writeValueAsString(collection);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
