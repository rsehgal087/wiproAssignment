package assignments;

import java.util.*;

public class Task13 {

    // Adjacency list representation of the graph
    private Map<Integer, List<Integer>> adjList;

    // Constructor for Task13
    public Task13() {
        adjList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Method to add an edge to the graph
    public void addEdge(int vertex1, int vertex2) {
        adjList.putIfAbsent(vertex1, new ArrayList<>());
        adjList.putIfAbsent(vertex2, new ArrayList<>());
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
    }

    // Method to remove a vertex from the graph
    public void removeVertex(int vertex) {
        adjList.values().forEach(e -> e.remove(Integer.valueOf(vertex)));
        adjList.remove(vertex);
    }

    // Method to remove an edge from the graph
    public void removeEdge(int vertex1, int vertex2) {
        List<Integer> eV1 = adjList.get(vertex1);
        List<Integer> eV2 = adjList.get(vertex2);
        if (eV1 != null) eV1.remove(Integer.valueOf(vertex2));
        if (eV2 != null) eV2.remove(Integer.valueOf(vertex1));
    }

    // Method to check if a vertex exists in the graph
    public boolean hasVertex(int vertex) {
        return adjList.containsKey(vertex);
    }

    // Method to check if an edge exists in the graph
    public boolean hasEdge(int vertex1, int vertex2) {
        return adjList.containsKey(vertex1) && adjList.get(vertex1).contains(vertex2);
    }

    // Depth-First Search (DFS)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int adj : adjList.get(vertex)) {
            if (!visited.contains(adj)) {
                dfsUtil(adj, visited);
            }
        }
    }

    // Breadth-First Search (BFS)
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adj : adjList.get(vertex)) {
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        Task13 graph = new Task13();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // Perform DFS starting from vertex 1
        System.out.println("DFS starting from vertex 1:");
        graph.dfs(1);
        System.out.println();

        // Perform BFS starting from vertex 1
        System.out.println("BFS starting from vertex 1:");
        graph.bfs(1);
        System.out.println();

        // Check for vertex existence
        System.out.println("Graph has vertex 3: " + graph.hasVertex(3));
        System.out.println("Graph has vertex 6: " + graph.hasVertex(6));

        // Check for edge existence
        System.out.println("Graph has edge between 1 and 3: " + graph.hasEdge(1, 3));
        System.out.println("Graph has edge between 1 and 5: " + graph.hasEdge(1, 5));

        // Remove an edge
        graph.removeEdge(1, 3);
        System.out.println("Graph has edge between 1 and 3 after removal: " + graph.hasEdge(1, 3));

        // Remove a vertex
        graph.removeVertex(3);
        System.out.println("Graph has vertex 3 after removal: " + graph.hasVertex(3));
    }
}

