package assignments;

import java.util.*;

public class Task17 {

    // Inner class to represent a node in the priority queue
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Method to add an edge to the graph
    private void addEdge(Map<Integer, List<Node>> graph, int source, int dest, int weight) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(dest, new ArrayList<>());
        graph.get(source).add(new Node(dest, weight));
        graph.get(dest).add(new Node(source, weight)); // If the graph is undirected
    }

    // Method to implement Dijkstra's algorithm
    public void dijkstra(Map<Integer, List<Node>> graph, int source) {
        // Priority queue to store the vertices to be processed
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // Map to store the shortest distance from the source to each vertex
        Map<Integer, Integer> distances = new HashMap<>();
        // Set to store the processed vertices
        Set<Integer> processed = new HashSet<>();

        // Initialize distances and add source vertex to the priority queue
        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            // Extract the vertex with the minimum distance
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;

            // If this vertex is already processed, skip it
            if (processed.contains(currentVertex)) {
                continue;
            }

            // Mark the vertex as processed
            processed.add(currentVertex);

            // Update the distances of adjacent vertices
            for (Node neighbor : graph.get(currentVertex)) {
                if (!processed.contains(neighbor.vertex)) {
                    int newDist = distances.get(currentVertex) + neighbor.distance;
                    if (newDist < distances.get(neighbor.vertex)) {
                        distances.put(neighbor.vertex, newDist);
                        pq.add(new Node(neighbor.vertex, newDist));
                    }
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from vertex " + source + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Task17 graph = new Task17();
        Map<Integer, List<Node>> adjList = new HashMap<>();

        // Adding edges to the graph
        graph.addEdge(adjList, 0, 1, 4);
        graph.addEdge(adjList, 0, 7, 8);
        graph.addEdge(adjList, 1, 2, 8);
        graph.addEdge(adjList, 1, 7, 11);
        graph.addEdge(adjList, 2, 3, 7);
        graph.addEdge(adjList, 2, 8, 2);
        graph.addEdge(adjList, 2, 5, 4);
        graph.addEdge(adjList, 3, 4, 9);
        graph.addEdge(adjList, 3, 5, 14);
        graph.addEdge(adjList, 4, 5, 10);
        graph.addEdge(adjList, 5, 6, 2);
        graph.addEdge(adjList, 6, 7, 1);
        graph.addEdge(adjList, 6, 8, 6);
        graph.addEdge(adjList, 7, 8, 7);

        // Running Dijkstra's algorithm from source vertex 0
        graph.dijkstra(adjList, 0);
    }
}

