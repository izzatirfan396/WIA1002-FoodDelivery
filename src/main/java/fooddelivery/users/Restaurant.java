package fooddelivery.users;

/**
 * Represents a restaurant registered in the system.
 * Member: [M1 Name]
 */
public class Restaurant {

    private String restaurantId;
    private String name;
    private String address;

    public Restaurant(String restaurantId, String name, String address) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
    }

    // TODO (M1): add getters, setters, and toString() below

    @Override
    public String toString() {
        return "Restaurant{id='" + restaurantId + "', name='" + name + "'}";
    }
}
