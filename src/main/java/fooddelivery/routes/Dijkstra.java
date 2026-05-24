package fooddelivery.routes;
import java.util.Scanner;
/**
 * Dijkstra's Shortest Path Algorithm
 * Member: HARITH DANISH
 * Finds the shortest delivery route between two locations.
 */
public class Dijkstra {

    private Graph graph;
    private static final int INF = Integer.MAX_VALUE;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public void findShortestPath(String source, String destination) {
        int srcIdx = graph.getIndex(source);
        int destIdx = graph.getIndex(destination);

        if (srcIdx == -1 || destIdx == -1) {
            System.out.println("Error: Source or Destination location not found on map.");
            return;
        }

        int n = graph.getNumLocations();
        int[][] adjMatrix = graph.getAdjMatrix();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n]; // Array to reconstruct the shortest path route

        // 1. Initialize arrays
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            visited[i] = false;
            parent[i] = -1;
        }
        dist[srcIdx] = 0;

        // 3. Main Algorithm loop
        for (int count = 0; count < n - 1; count++) {
            // Pick unvisited node with minimum distance
            int u = findMinDistanceNode(dist, visited, n);
            if (u == -1 || dist[u] == INF) {
                break;
            }

            // Mark Node as visited
            visited[u] = true;

            // Relax neighbors
            for (int v = 0; v < n; v++) {
                if (!visited[v] && adjMatrix[u][v] != INF && dist[u] != INF) {
                    if (dist[u] + adjMatrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + adjMatrix[u][v];
                        parent[v] = u;
                    }
                }
            }
        }

        // 4. Print results
        if (dist[destIdx] == INF) {
            System.out.println("\nNo available route exists between " + source + " and " + destination + ".");
        } else {
            System.out.println("\n==========================================");
            System.out.println("         OPTIMAL DELIVERY ROUTE           ");
            System.out.println("==========================================");
            System.out.println("Source:      " + graph.getLocationName(srcIdx));
            System.out.println("Destination: " + graph.getLocationName(destIdx));
            System.out.println("Total Cost:  " + dist[destIdx] + " km");
            System.out.print("Path Taken:  ");
            printPath(parent, destIdx);
            System.out.println();
            System.out.println("==========================================");
        }
    }

    private int findMinDistanceNode(int[] dist, boolean[] visited, int n) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printPath(int[] parent, int currentIdx) {
        if (currentIdx == -1) {
            return;
        }
        printPath(parent, parent[currentIdx]);
        if (parent[currentIdx] == -1) {
            System.out.print(graph.getLocationName(currentIdx));
        } else {
            System.out.print(" -> " + graph.getLocationName(currentIdx));
        }
    }

    public void showMenu(Scanner sc) {
        int subChoice = -1;
        do {
            System.out.println("\n=== Module 4: Route Finder Menu ===");
            System.out.println("1. Add New Location Hub");
            System.out.println("2. Add Connected Road Network");
            System.out.println("3. View Entire Network Map Matrix");
            System.out.println("4. Calculate Shortest Delivery Route (Dijkstra)");
            System.out.println("0. Back to Main System");
            System.out.print("Enter choice: ");

            try {
                subChoice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                subChoice = -1;
            }

            switch (subChoice) {
                case 1:
                    System.out.print("Enter location hub name (e.g. CentralKitchen, HQ): ");
                    String locName = sc.nextLine().trim();
                    if (!locName.isEmpty()) {
                        graph.addLocation(locName);
                    }
                    break;
                case 2:
                    System.out.print("Enter Starting Location: ");
                    String from = sc.nextLine().trim();
                    System.out.print("Enter Ending Location: ");
                    String to = sc.nextLine().trim();
                    System.out.print("Enter Distance (km): ");
                    int dist = 0;
                    try {
                        dist = Integer.parseInt(sc.nextLine());
                        if (dist > 0) {
                            graph.addRoad(from, to, dist);
                        } else {
                            System.out.println("Distance must be greater than zero.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid numeric input for distance.");
                    }
                    break;
                case 3:
                    graph.display();
                    break;
                case 4:
                    System.out.print("Enter Departure Point: ");
                    String start = sc.nextLine().trim();
                    System.out.print("Enter Destination Delivery Point: ");
                    String end = sc.nextLine().trim();
                    findShortestPath(start, end);
                    break;
                case 0:
                    System.out.println("Exiting Route Finder module...");
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        } while (subChoice != 0);
    }
}
