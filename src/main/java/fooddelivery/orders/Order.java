package fooddelivery.orders;

/**
 * Represents a food order placed by a customer.
 * Member: [M2 Name]
 */
public class Order {

    private String orderId;
    private String userId;
    private String restaurantId;
    private String foodItem;
    private double totalPrice;
    private String status; // e.g. "PENDING", "PROCESSING", "DELIVERED", "CANCELLED"

    public Order(String orderId, String userId, String restaurantId, String foodItem, double totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.foodItem = foodItem;
        this.totalPrice = totalPrice;
        this.status = "PENDING";
    }

    // TODO (M2): add getters, setters, and toString() below

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', item='" + foodItem + "', status='" + status + "'}";
    }
}
