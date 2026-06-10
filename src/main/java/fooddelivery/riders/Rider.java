package fooddelivery.riders;

/**
 * Represents a delivery rider.
 * Member: HARIZ ARFAN
 */
public class Rider {
    //Create variables to store the rider details
    private String riderId;
    private String name;
    private int priority; // lower number = higher priority (e.g. 1 = nearest/available)
    private boolean isAvailable;

    public Rider(String riderId, String name, int priority) { //Constructor to setup variables when object is created
        this.riderId = riderId;
        this.name = name;
        this.priority = priority;
        this.isAvailable = true;
    }

    public int getPriority() { //Get the rider priority rank number
        return priority;
    }

    public boolean isAvailable() { //Check if the rider is free or busy
        return isAvailable;
    }

    public void setAvailable(boolean available) { //Change rider status when they take an order
        this.isAvailable = available;
    }

    
    public String getRiderId() { //Get the rider ID
        return riderId;
    }
    
    public void setRiderId(String riderId) { //Set or update the rider ID
        this.riderId = riderId;
    }
    
    public String getName() { //Get the rider ID
        return name;
    }
    
    public void setName(String name){ //Set or update the rider ID
        this.name = name;
    }
    
    public void setPriority(int priority) { //Set or update the priority rank number
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Rider{id='" + riderId + "', name='" + name + "', priority=" + priority + "}";
    }
}