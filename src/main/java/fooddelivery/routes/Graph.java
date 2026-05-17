package fooddelivery.routes;

/**
 * Module 4 - Delivery Map using a Weighted Graph
 * Member: [M4 Name]
 *
 * Data Structure: Graph (adjacency matrix or adjacency list)
 * Responsibilities:
 *   - Add locations (vertices) to the map
 *   - Add roads (weighted edges) between locations
 *   - Support Dijkstra's algorithm for shortest path
 */
public class Graph {

    // TODO (M4): choose adjacency matrix OR adjacency list and declare your fields
    // Option A (matrix): private int[][] adjMatrix; private String[] locationNames;
    // Option B (list):   private Map<String, List<int[]>> adjList;

    private int numLocations;
    private static final int MAX = 20;

    public Graph() {
        // TODO (M4): initialise your graph structure
        this.numLocations = 0;
    }

    public void addLocation(String name) {
        // TODO (M4): add a vertex to the graph
    }

    public void addRoad(String from, String to, int distance) {
        // TODO (M4): add a weighted edge between two locations (undirected)
    }

    public void display() {
        // TODO (M4): print the adjacency matrix or list
    }

    public int getNumLocations() {
        return numLocations;
    }

    // TODO (M4): add any helper methods Dijkstra will need (e.g. getIndex, getDistance)
}
