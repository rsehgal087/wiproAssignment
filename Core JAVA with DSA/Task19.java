package assignments;

import java.util.*;

public class Task19 {

    // Inner class to represent an edge with its weight
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Method to find the MST using Kruskal's algorithm
    public void kruskalMST(int V, List<Edge> edges) {
        // Sort all edges in non-decreasing order of their weight
        Collections.sort(edges);

        // Parent array to track subsets
        int[] parent = new int[V];
        // Rank array for union-find
        int[] rank = new int[V];

        // Initialize each subset as its own parent
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mst = new ArrayList<>(); // Store the MST edges

        int edgeCount = 0; // Count of edges added to the MST
        int index = 0; // Index for sorted edges list

        // MST has V-1 edges
        while (edgeCount < V - 1 && index < edges.size()) {
            Edge nextEdge = edges.get(index++);
            int rootX = find(parent, nextEdge.source);
            int rootY = find(parent, nextEdge.destination);

            // If including this edge does not cause a cycle, include it in the MST
            if (rootX != rootY) {
                mst.add(nextEdge);
                union(parent, rank, rootX, rootY);
                edgeCount++;
            }
        }

        // Print the MST
        System.out.println("Minimum Spanning Tree (Kruskal's MST):");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
    }

    // Helper function to find the subset of an element
    private int find(int[] parent, int vertex) {
        // Path compression
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    // Helper function to perform union of two subsets
    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void main(String[] args) {
        Task19 graph = new Task19();
        int V = 4; // Number of vertices

        // List of edges (source, destination, weight)
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        // Find MST using Kruskal's algorithm
        graph.kruskalMST(V, edges);
    }
}

