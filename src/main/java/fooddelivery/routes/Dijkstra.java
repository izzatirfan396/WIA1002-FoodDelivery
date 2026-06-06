package fooddelivery.routes;

import fooddelivery.utils.InputHelper;
import java.util.Scanner;

/**
 * Dijkstra's Shortest Path Algorithm
 * Member: HARITH
 * 
 * Finds the shortest delivery route between two locations.
 */
public class Dijkstra {

    private Graph graph;
    private static final int INF = Integer.MAX_VALUE;

    public Dijkstra(Graph graph) {  
        this.graph = graph;  
    }

    public void findShortestPath(String source, String destination) {  
        int uSrc = graph.getIdxByName(source);
        int vDst = graph.getIdxByName(destination);
        
        if (uSrc == -1 || vDst == -1) {
            System.out.println("Error: Path bounds calculation aborted because nodes are missing from definitions.");
            return;
        }
        
        int n = graph.getNumLocations();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n]; 
        
        // 1. Initialise tracking blocks
        for (int i = 0; i < n; i++) {
            dist[i] = INF; // Initialize all elements to infinity
            visited[i] = false;
            parent[i] = -1; 
        }
        dist[uSrc] = 0; // Source cost is zero
        
        // 3. Main processing exploration passes
        for (int count = 0; count < n - 1; count++) {
            // Locate the non-visited element with the lowest running calculation value
            int u = -1;
            int minDist = INF;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }
            
            if (u == -1) break; // Remaining unvisited vertices are unreachable
            
            visited[u] = true; // Mark node as visited
            
            // Relax neighbors
            int[][] matrix = graph.getAdjMatrix();
            for (int v = 0; v < n; v++) {
                if (!visited[v] && matrix[u][v] != INF && dist[u] != INF) {
                    if (dist[u] + matrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + matrix[u][v];
                        parent[v] = u; // Map ancestry tracking reference
                    }
                }
            }
        }
        
        // 4. Output results
        if (dist[vDst] == INF) {
            System.out.println("\nResult: No accessible route found linking '" + source + "' to '" + destination + "'.");
        } else {
            System.out.println("\n============================================");
            System.out.println("OPTIMAL ROUTE COMPUTATION SUCCESSFUL");
            System.out.println("============================================");
            System.out.println("Total Delivery Cost/Distance: " + dist[vDst] + " meters");
            System.out.print("Route Path Mapping: ");
            printPathTrace(vDst, parent);
            System.out.println();
            System.out.println("============================================");
        }
    }
    
    // Recursive tracker logic for parsing historical edge branches sequentially
    private void printPathTrace(int targetIdx, int[] parent) {
        if (parent[targetIdx] == -1) {
            System.out.print(graph.getLocationByIdx(targetIdx).getName());
            return;
        }
        printPathTrace(parent[targetIdx], parent);
        System.out.print(" -> " + graph.getLocationByIdx(targetIdx).getName());
    }

    public void showMenu(Scanner sc) {  
        int choice = -1;
        
        do {
            System.out.println("\n=============================================");
            System.out.println("MODULE 4: SYSTEM ROUTE FINDER & ROAD ENGINE");
            System.out.println("=============================================");
            System.out.println("1. Add Map Location (Vertex)");
            System.out.println("2. Add Road Connector Line (Weighted Edge)");
            System.out.println("3. Display Structural Network Layout Graph");
            System.out.println("4. Compute Shortest Route (Dijkstra Calculation)");
            System.out.println("5. Return to Main Menu");
            System.out.print("Please enter your choice (1-5): ");
            
            choice = InputHelper.readInt(sc); // Utilise shared helper validation metrics
            switch (choice) {
                case 1:
                    System.out.print("Enter Location Node Name (e.g. Subang, PJ): ");
                    String nodeName = InputHelper.readString(sc);
                    graph.addLocation(nodeName);
                    break;
                case 2:
                    System.out.print("Enter Origin Point (From Name): ");
                    String from = InputHelper.readString(sc);
                    System.out.print("Enter Target Destination (To Name): ");
                    String to = InputHelper.readString(sc);
                    System.out.print("Enter Path Metric Distance Weight: ");
                    int weight = InputHelper.readInt(sc);
                    graph.addRoad(from, to, weight);
                    break;
                case 3:
                    graph.display();
                    break;
                case 4:
                    System.out.print("Enter Starting Point Location Name: ");
                    String src = InputHelper.readString(sc);
                    System.out.print("Enter Destination Delivery Location Name: ");
                    String dest = InputHelper.readString(sc);
                    findShortestPath(src, dest);
                    break;
                case 5:
                    System.out.println("Returning back to central integration layer...");
                    break;
                default:
                    System.out.println("Invalid input selection. Choose option between 1 and 5.");
            }
        } while (choice != 5);
    }  
}