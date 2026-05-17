package fooddelivery.search;

/**
 * Represents a food item stored in the BST.
 * Member: [M5 Name]
 */
public class FoodItem {

    private String itemId;
    private String name;       // BST key — sorted alphabetically by name
    private String category;
    private double price;
    private String restaurantId;

    public FoodItem(String itemId, String name, String category, double price, String restaurantId) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // TODO (M5): add remaining getters and toString()

    @Override
    public String toString() {
        return String.format("%-20s | %-15s | RM%.2f", name, category, price);
    }
}
