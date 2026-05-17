package fooddelivery.routes;

/**
 * Dijkstra's Shortest Path Algorithm
 * Member: [M4 Name]
 *
 * Finds the shortest delivery route between two locations.
 */
public class Dijkstra {

    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public void findShortestPath(String source, String destination) {
        // TODO (M4): implement Dijkstra's algorithm here
        // Steps:
        //   1. Initialise dist[] array with Integer.MAX_VALUE, set dist[source] = 0
        //   2. Use a visited[] boolean array
        //   3. Repeat: pick unvisited node with min dist, mark visited, relax neighbours
        //   4. Print the shortest distance and path
    }

    public void showMenu() {
        // TODO (M4): implement the sub-menu for this module
    }
}
