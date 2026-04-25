package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.LinkedHashMap;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    public Map<String, Integer> getFruits() {
        return fruits;
    }

    private final Map<String, Integer> fruits = new LinkedHashMap<>();

    @Override
    public void add(FruitTransaction fruit) {
        fruits.put(fruit.getName(), fruit.getQuantity());
    }

    @Override
    public int actualQuantity(String fruitName) {
        return fruits.get(fruitName);
    }

    @Override
    public void updateQuantity(String fruitName, int quantity) {
        fruits.put(fruitName, quantity);
    }

    @Override
    public Map<String, Integer> getData() {
        return new LinkedHashMap<>(fruits);
    }

    public boolean checkFruit(String fruitName) {
        return fruits.containsKey(fruitName);
    }
}
