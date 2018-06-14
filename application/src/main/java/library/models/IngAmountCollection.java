package library.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.util.Pair;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IngAmountCollection implements Iterable<IngAmountPair>, Serializable {
    Map<String, Double>  collection = new HashMap<>();
    private ObjectMapper mapper = new ObjectMapper();

    public IngAmountCollection(){}

    public IngAmountCollection(Map<String, Double> collection){
        this.collection = collection;
    }

    public IngAmountCollection(Iterable<Pair<String, Double>> collection){
        for (Pair<String, Double> p : collection) {
            this.add(p.getFirst(), p.getSecond());
        }
    }

    public void add(String ingredientName, Double amount){
        collection.put(ingredientName, amount);
    }

    public boolean has(String ingredientName){
        return collection.containsKey(ingredientName);
    }

    public void update(String ingredientName, double amount){
        if (this.has(ingredientName)) {
            collection.replace(ingredientName, amount);
        } else {
            collection.put(ingredientName, amount);
        }
    }

    public double getAmount(String ingredientName){
        if(!collection.containsKey(ingredientName))
            return 0;
        return  collection.get(ingredientName);
    }

    public Set<String> getIngredientSet(){
        return collection.keySet();
    }

    @Override
    public Iterator<IngAmountPair> iterator() {
        return new Iterator<IngAmountPair>(){
            final Iterator<Map.Entry<String, Double>> it = collection.entrySet().iterator();

            public boolean hasNext() {
                return it.hasNext();
            }
            public IngAmountPair next() {
                return transformElem(it.next());
            }
            public void remove() {
                // ...
            }
        };
//        return collection.entrySet().iterator();
    }

    private IngAmountPair transformElem(Map.Entry<String, Double> entry){
        return new IngAmountPair(entry.getKey(), entry.getValue());
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
