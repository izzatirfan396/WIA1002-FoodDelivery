package fooddelivery.users;

/**
 * Represents a customer in the system.
 * Member: [M1 Name]
 */
public class User {

    private String userId;
    private String name;
    private String phone;
    private String address;

    public User(String userId, String name, String phone, String address) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    // TODO (M1): add getters, setters, and toString() below

    @Override
    public String toString() {
        return "User{userId='" + userId + "', name='" + name + "'}";
    }
}
