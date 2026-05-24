package fooddelivery.routes;

/**
 * Module 4 - Delivery Map using a Weighted Graph 
 * Member: HARITH DANISH
 * Data Structure: Graph (adjacency matrix or adjacency list) Responsibilities:
 * - Add locations (vertices) to the map - Add roads (weighted edges) between
 * locations - Support Dijkstra's algorithm for shortest path
 */

public class Graph {

    private int[][] adjMatrix;
    private String[] locationNames;
    private int numLocations;
    private static final int MAX = 20;
    private static final int INF = Integer.MAX_VALUE;

    public Graph() {
        this.numLocations = 0;
        this.adjMatrix = new int[MAX][MAX];
        this.locationNames = new String[MAX];

        // Initialize the matrix with INF (no connection) and 0 for self-paths
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = INF;
                }
            }
        }
    }

    public void addLocation(String name) {
        if (numLocations >= MAX) {
            System.out.println("Error: Maximum location limit reached (" + MAX + ").");
            return;
        }
        if (getIndex(name) != -1) {
            System.out.println("Location '" + name + "' already exists.");
            return;
        }
        locationNames[numLocations] = name;
        numLocations++;
        System.out.println("Location added successfully: " + name);
    }

    public void addRoad(String from, String to, int distance) {
        int fromIndex = getIndex(from);
        int toIndex = getIndex(to);

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("Error: One or both locations do not exist. Please add them first.");
            return;
        }

        // Undirected road mapping
        adjMatrix[fromIndex][toIndex] = distance;
        adjMatrix[toIndex][fromIndex] = distance;
        System.out.println("Road added: " + from + " <-> " + to + " (" + distance + " km)");
    }

    public void display() {
        if (numLocations == 0) {
            System.out.println("\n[The delivery map is currently empty]");
            return;
        }

        System.out.println("\n--- Delivery Map Grid Matrix ---");
        System.out.print(String.format("%-15s", ""));
        for (int i = 0; i < numLocations; i++) {
            System.out.print(String.format("%-15s", locationNames[i]));
        }
        System.out.println();

        for (int i = 0; i < numLocations; i++) {
            System.out.print(String.format("%-15s", locationNames[i]));
            for (int j = 0; j < numLocations; j++) {
                if (adjMatrix[i][j] == INF) {
                    System.out.print(String.format("%-15s", "INF"));
                } else {
                    System.out.print(String.format("%-15s", adjMatrix[i][j] + " km"));
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
    }

    public int getNumLocations() {
        return numLocations;
    }

    // --- UTILITY COORD HELPERS FOR DIJKSTRA ---
    public int getIndex(String name) {
        for (int i = 0; i < numLocations; i++) {
            if (locationNames[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getLocationName(int index) {
        if (index >= 0 && index < numLocations) {
            return locationNames[index];
        }
        return null;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}