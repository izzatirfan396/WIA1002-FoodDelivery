package fooddelivery.search;

/**
 * Represents a food item stored in the BST.
 * Member: ZUL DANIAL
 */
public class FoodItem {

    private String itemId;
    private String name;       
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

    public String getItemId() {
        return itemId;
    }

    public String getCategory() {
        return category;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-20s | Category: %-12s | Price: RM%.2f | RestID: %s", 
                itemId, name, category, price, restaurantId);
    }
}