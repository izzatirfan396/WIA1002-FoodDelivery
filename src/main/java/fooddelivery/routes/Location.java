package fooddelivery.routes;

/**
 * Represents a location (node) in the delivery map.
 * Member: Module 4 Route Finder Specialist
 */
public class Location {

    private String locationId;
    private String name;

    public Location(String locationId, String name) {  
        this.locationId = locationId;  
        this.name = name;  
    }

    public String getLocationId() {  
        return locationId;  
    }

    public String getName() {  
        return name;  
    }

    @Override  
    public String toString() {  
        return name;  
    }  
}