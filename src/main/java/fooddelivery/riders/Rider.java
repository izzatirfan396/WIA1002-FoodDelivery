package fooddelivery.riders;

/**
 * Represents a delivery rider.
 * Member: HARIZ ARFAN
 */
public class Rider {

    private String riderId;
    private String name;
    private int priority; // lower number = higher priority (e.g. 1 = nearest/available)
    private boolean isAvailable;

    public Rider(String riderId, String name, int priority) {
        this.riderId = riderId;
        this.name = name;
        this.priority = priority;
        this.isAvailable = true;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // TODO (M3): add remaining getters, setters, and toString() below
    
    public String getRiderId() {
        return riderId;
    }
    
    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){ 
        this.name = name;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Rider{id='" + riderId + "', name='" + name + "', priority=" + priority + "}";
    }
}
