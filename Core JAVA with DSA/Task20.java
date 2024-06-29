package assignments;

import java.util.*;

public class Task20 {

    // Inner class to represent an edge with its source, destination, and weight
    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Method to implement the Bellman-Ford algorithm
    public void bellmanFord(int V, List<Edge> edges, int source) {
        // Step 1: Initialize distances from source to all other vertices as INFINITE
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Step 2: Relax all edges |V| - 1 times
        for (int i = 1; i < V; ++i) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Step 4: Print the shortest distances
        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < V; ++i) {
            System.out.println("Vertex " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Task20 graph = new Task20();
        int V = 5; // Number of vertices

        // List of edges (source, destination, weight)
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        // Find shortest paths using Bellman-Ford algorithm from source vertex 0
        graph.bellmanFord(V, edges, 0);
    }
}

