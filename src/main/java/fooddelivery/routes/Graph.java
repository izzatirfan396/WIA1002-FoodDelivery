package fooddelivery.routes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Module 4 - Delivery Map using a Weighted Graph
 * Member: HARITH
 *
 * Data Structure: Graph (Adjacency List structure using a Map)
 * Responsibilities:
 * - Add locations (vertices) to the map
 * - Add roads (weighted edges) between locations
 * - Support Dijkstra's algorithm for shortest path
 */
public class Graph {
    
    // Custom internal class to represent a weighted edge/road
    public static class Edge {
        String targetLocation;
        int distance;

        public Edge(String targetLocation, int distance) {
            this.targetLocation = targetLocation;
            this.distance = distance;
        }
        
        public String getTargetLocation() { return targetLocation; }
        public int getDistance() { return distance; }
    }

    private Map<String, List<Edge>> adjList;
    private int numLocations;

    // Initialise your graph structure
    public Graph() {
        this.adjList = new HashMap<>();
        this.numLocations = 0;
    }

    // Add a vertex to the graph
    public void addLocation(String name) {
        if (name == null || name.trim().isEmpty()) return;
        String cleanName = name.trim();
        if (!adjList.containsKey(cleanName)) {
            adjList.put(cleanName, new ArrayList<>());
            numLocations++;
            System.out.println("Location added successfully: " + cleanName);
        } else {
            System.out.println("Location already exists: " + cleanName);
        }
    }

    // Add a weighted edge between two locations (undirected)
    public void addRoad(String from, String to, int distance) {
        if (from == null || to == null) return;
        String cleanFrom = from.trim();
        String cleanTo = to.trim();

        // Safety check to ensure both locations exist before joining them
        if (!adjList.containsKey(cleanFrom) || !adjList.containsKey(cleanTo)) {
            System.out.println("Error: One or both locations do not exist in the map.");
            return;
        }

        // Since it's undirected, add edge in both directions
        adjList.get(cleanFrom).add(new Edge(cleanTo, distance));
        adjList.get(cleanTo).add(new Edge(cleanFrom, distance));
        System.out.println("Road created: " + cleanFrom + " <--> " + cleanTo + " (" + distance + " km)");
    }

    // Print the adjacency list
    public void display() {
        if (adjList.isEmpty()) {
            System.out.println("The delivery map is currently empty.");
            return;
        }
        System.out.println("\n--- Delivery Map Layout (Adjacency List) ---");
        for (Map.Entry<String, List<Edge>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " connects to: ");
            List<Edge> edges = entry.getValue();
            if (edges.isEmpty()) {
                System.out.print("[No connections]");
            } else {
                for (int i = 0; i < edges.size(); i++) {
                    Edge edge = edges.get(i);
                    System.out.print(edge.targetLocation + " (" + edge.distance + "km)");
                    if (i < edges.size() - 1) System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public int getNumLocations() {
        return numLocations;
    }

    // Helper method that Dijkstra will need to fetch neighbors
    public List<Edge> getNeighbors(String locationName) {
        return adjList.get(locationName);
    }

    // Helper method to verify if a location name is registered in our map
    public boolean hasLocation(String locationName) {
        return adjList.containsKey(locationName);
    }

    // Helper method to pull all unique location names (useful for index-mapping in Dijkstra)
    public List<String> getAllLocationNames() {
        return new ArrayList<>(adjList.keySet());
    }
}