package fooddelivery.routes;

/**
 * Module 4 - Represents a physical location (vertex) on the delivery map.
 * Member: HARITH
 */
public class Location {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return name.equalsIgnoreCase(location.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}