package library.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.util.Pair;

import java.io.Serializable;
import java.util.*;

public class IngredientAmountMap implements Iterable<IngredientAmountEntry>, Serializable {
    Map<String, Double> map = new HashMap<>();
    private ObjectMapper mapper = new ObjectMapper();

    public IngredientAmountMap(){}

    public IngredientAmountMap(Map<String, Double> map){
        this.map = map;
    }

    public IngredientAmountMap(Iterable<Pair<String, Double>> map){
        for (Pair<String, Double> p : map) {
            this.add(p.getFirst(), p.getSecond());
        }
    }

    public void add(String ingredientName, Double amount){
        map.put(ingredientName, amount);
    }

    public void remove(String ingredientName) { map.remove(ingredientName); }

    public boolean has(String ingredientName){
        return map.containsKey(ingredientName);
    }

    public void update(String ingredientName, double amount){
        if (this.has(ingredientName)) {
            map.replace(ingredientName, amount);
        } else {
            map.put(ingredientName, amount);
        }
    }

    public double getAmount(String ingredientName){
        if(!map.containsKey(ingredientName))
            return 0;
        return  map.get(ingredientName);
    }

    public Set<String> getIngredientSet(){
        return map.keySet();
    }


    public List<IngredientAmountEntry> getIngredientAmountEntries(){
        ArrayList<IngredientAmountEntry> entries = new ArrayList<>();
        for(Map.Entry<String, Double> entry : map.entrySet()){
            entries.add(new IngredientAmountEntry(entry.getKey(), entry.getValue()));
        }
        return entries;
    }

    @Override
    public Iterator<IngredientAmountEntry> iterator() {
        return new Iterator<IngredientAmountEntry>(){
            final Iterator<Map.Entry<String, Double>> it = map.entrySet().iterator();

            public boolean hasNext() {
                return it.hasNext();
            }
            public IngredientAmountEntry next() {
                return transformElem(it.next());
            }
            public void remove() {
                // ...
            }
        };
    }

    private IngredientAmountEntry transformElem(Map.Entry<String, Double> entry){
        return new IngredientAmountEntry(entry.getKey(), entry.getValue());
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
