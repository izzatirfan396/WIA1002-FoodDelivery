package fooddelivery.orders;

/**
 * Represents a food order placed by a customer.
 * Member: FARISH CHAI
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

    // --- GETTERS ---

    public String getOrderId() { return orderId; }

    public String getUserId() { return userId; }

    public String getRestaurantId() { return restaurantId; }

    public String getFoodItem() { return foodItem; }

    public double getTotalPrice() { return totalPrice;}

    public String getStatus() { return status; }

    // --- SETTERS ---

    public void setOrderId(String orderId) { this.orderId = orderId; }

    public void setUserId(String userId) { this.userId = userId; }

    public void setRestaurantId(String restaurantId) { this.restaurantId = restaurantId; }

    public void setFoodItem(String foodItem) { this.foodItem = foodItem; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public void setStatus(String status) { this.status = status; }

    // --- TO STRING ---

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', item='" + foodItem + "', price=" + totalPrice + ", status='" + status + "'}";
    }
}