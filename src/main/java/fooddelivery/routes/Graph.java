package fooddelivery.routes;

/**
 * Module 4 - Delivery Map using a Weighted Graph
 * Member: Module 4 Route Finder Specialist
 *
 * Data Structure: Graph (Adjacency Matrix configuration)
 * Responsibilities:
 * - Add locations (vertices) to the map
 * - Add roads (weighted edges) between locations
 * - Support Dijkstra's algorithm for shortest path
 */
public class Graph {

    private int[][] adjMatrix; 
    private Location[] locations;
    private int numLocations;  
    private static final int MAX = 20; // Maximum allowed locations
    private static final int INF = Integer.MAX_VALUE;

    public Graph() {  
        this.numLocations = 0;  // Initialises graph structure
        this.locations = new Location[MAX];
        this.adjMatrix = new int[MAX][MAX];
        
        // Initialize weights to Infinity representing unlinked spaces
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0; // Local path cost is zero
                } else {
                    adjMatrix[i][j] = INF;
                }
            }
        }
    }

    public void addLocation(String name) {  
        if (numLocations >= MAX) {
            System.out.println("Error: Graph map has reached maximum capacity!");
            return;
        }
        if (getIdxByName(name) != -1) {
            System.out.println("Location '" + name + "' already exists in the system mapping.");
            return;
        }
        
        // Auto-generate a descriptive padded internal ID
        String autoId = "L" + String.format("%03d", (numLocations + 1));
        locations[numLocations] = new Location(autoId, name);
        numLocations++;
        System.out.println("Successfully added map location: " + name + " (" + autoId + ")");
    }

    public void addRoad(String from, String to, int distance) {  
        int u = getIdxByName(from);
        int v = getIdxByName(to);
        
        if (u == -1 || v == -1) {
            System.out.println("Error: One or both location names could not be verified in the map registry.");
            return;
        }
        
        // Undirected edge tracking representation
        adjMatrix[u][v] = distance;
        adjMatrix[v][u] = distance;
        System.out.println("Road mapped successfully: " + from + " <-> " + to + " (" + distance + "m)");
    }

    public void display() {  
        if (numLocations == 0) {
            System.out.println("\n[The delivery map network contains no node data entries]");
            return;
        }
        
        System.out.println("\n--- Current Delivery Network Layout (Adjacency Matrix) ---");
        System.out.print(String.format("%-15s", ""));
        for (int i = 0; i < numLocations; i++) {
            System.out.print(String.format("%-12s", locations[i].getName()));
        }
        System.out.println();
        
        for (int i = 0; i < numLocations; i++) {
            System.out.print(String.format("%-15s", locations[i].getName()));
            for (int j = 0; j < numLocations; j++) {
                if (adjMatrix[i][j] == INF) {
                    System.out.print(String.format("%-12s", "INF"));
                } else {
                    System.out.print(String.format("%-12d", adjMatrix[i][j]));
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");
    }

    public int getNumLocations() {  
        return numLocations;  
    }
    
    // Core Helper operations required to translate labels safely into working array matrix indices
    public int getIdxByName(String name) {
        for (int i = 0; i < numLocations; i++) {
            if (locations[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public Location getLocationByIdx(int index) {
        if (index >= 0 && index < numLocations) {
            return locations[index];
        }
        return null;
    }
    
    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}