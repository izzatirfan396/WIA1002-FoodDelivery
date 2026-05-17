package fooddelivery.search;

import java.util.HashMap;

/**
 * Fast lookup cache using HashMap.
 * Member: [M5 Name]
 *
 * Data Structure: HashMap
 * Use case: quickly retrieve a FoodItem by its ID without traversing the BST.
 */
public class DataCache {

    private HashMap<String, FoodItem> cache;

    public DataCache() {
        cache = new HashMap<>();
    }

    public void put(String itemId, FoodItem item) {
        cache.put(itemId, item);
    }

    public FoodItem get(String itemId) {
        return cache.getOrDefault(itemId, null);
    }

    public boolean contains(String itemId) {
        return cache.containsKey(itemId);
    }

    public void remove(String itemId) {
        cache.remove(itemId);
    }

    public void displayAll() {
        // TODO (M5): iterate and print all cached items
        for (String key : cache.keySet()) {
            System.out.println(key + " => " + cache.get(key));
        }
    }
}
