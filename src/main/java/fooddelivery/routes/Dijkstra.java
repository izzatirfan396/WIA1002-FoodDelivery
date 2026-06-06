package fooddelivery.routes;

import fooddelivery.utils.InputHelper;
import java.util.*;

/**
 * Module 4 - Route Finder implementing Dijkstra's Algorithm
 * Member: HARITH
 */
public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    /**
     * Finds and prints the shortest path and total distance from source to destination.
     */
    public void runDijkstra(String source, String destination) {
        source = source.trim();
        destination = destination.trim();

        if (!graph.hasLocation(source) || !graph.hasLocation(destination)) {
            System.out.println("Error: Source or Destination location does not exist in the map.");
            return;
        }

        // Step 0: Create index mappings to map arbitrary string keys to simple arrays
        List<String> nodes = graph.getAllLocationNames();
        int n = nodes.size();
        Map<String, Integer> nameToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToIdx.put(nodes.get(i), i);
        }

        // Step 1: Initialise dist[] array with Integer.MAX_VALUE, set dist[source] = 0
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int srcIdx = nameToIdx.get(source);
        dist[srcIdx] = 0;

        // Tracks previous node indices for tracing the optimal path backwards
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // Step 2: Use a visited[] boolean array
        boolean[] visited = new boolean[n];

        // Step 3: Repeat: pick unvisited node with min dist, mark visited, relax neighbours
        for (int count = 0; count < n; count++) {
            // Find unvisited node with minimum distance value
            int uIdx = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    uIdx = i;
                }
            }

            // If the closest node is unreachable, processing completes
            if (uIdx == -1) break;

            // Mark the chosen node as visited
            visited[uIdx] = true;
            String uName = nodes.get(uIdx);

            // Stop calculation early if we have finalized our exact destination target node
            if (uName.equalsIgnoreCase(destination)) break;

            // Relax neighbors of u
            List<Graph.Edge> neighbors = graph.getNeighbors(uName);
            if (neighbors != null) {
                for (Graph.Edge edge : neighbors) {
                    int vIdx = nameToIdx.get(edge.getTargetLocation());
                    int weight = edge.getDistance();

                    if (!visited[vIdx] && dist[uIdx] != Integer.MAX_VALUE 
                            && dist[uIdx] + weight < dist[vIdx]) {
                        dist[vIdx] = dist[uIdx] + weight;
                        parent[vIdx] = uIdx;
                    }
                }
            }
        }

        // Step 4: Print the shortest distance and path
        int destIdx = nameToIdx.get(destination);
        if (dist[destIdx] == Integer.MAX_VALUE) {
            System.out.println("No route found from " + source + " to " + destination);
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("SHORTEST ROUTE FOUND");
        System.out.println("==============================================");
        System.out.println("Total Delivery Distance: " + dist[destIdx] + " km");
        
        // Reconstruct path from target backtracking to origin
        List<String> path = new ArrayList<>();
        int curr = destIdx;
        while (curr != -1) {
            path.add(nodes.get(curr));
            curr = parent[curr];
        }
        Collections.reverse(path);

        System.out.print("Optimal Route Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" -> ");
        }
        System.out.println("\n==============================================");
    }

    /**
     * Displays sub-menu options for Route Finder interactive operations
     */
    public void showMenu(Scanner sc) {
        int choice = -1;
        do {
            System.out.println("\n--- MODULE 4: ROUTE FINDER DELIVERY MAP ---");
            System.out.println("1. Add Delivery Location Node");
            System.out.println("2. Add Connected Road Edge");
            System.out.println("3. View Map Layout Configuration");
            System.out.println("4. Find Shortest Path Route (Dijkstra)");
            System.out.println("0. Return to Main Menu");
            System.out.println("-------------------------------------------");
            System.out.print("Enter choice: ");
            
            choice = InputHelper.readInt(sc); // Shared scanner reading utility

            switch (choice) {
                case 1:
                    System.out.print("Enter Location Name (e.g. Central Kitchen, Hub A): ");
                    String locName = sc.nextLine().trim();
                    graph.addLocation(locName);
                    break;
                case 2:
                    System.out.print("Enter Starting Location Name: ");
                    String fromLoc = sc.nextLine().trim();
                    System.out.print("Enter Target Destination Location Name: ");
                    String toLoc = sc.nextLine().trim();
                    System.out.print("Enter Route Distance Separation (in km): ");
                    int distance = InputHelper.readInt(sc);
                    graph.addRoad(fromLoc, toLoc, distance);
                    break;
                case 3:
                    graph.display();
                    break;
                case 4:
                    System.out.print("Enter Starting Node Name: ");
                    String startNode = sc.nextLine().trim();
                    System.out.print("Enter Ending Destination Node Name: ");
                    String endNode = sc.nextLine().trim();
                    runDijkstra(startNode, endNode);
                    break;
                case 0:
                    System.out.println("Returning back to Main Menu dispatch loop...");
                    break;
                default:
                    System.out.println("Invalid structural selection option. Try again.");
            }
        } while (choice != 0);
    }
}