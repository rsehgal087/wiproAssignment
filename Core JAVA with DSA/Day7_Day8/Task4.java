package Day7_Day8;

import java.util.*;

class Task4 {

    static class Graph {
        private int vertices;
        private List<List<Integer>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        // Method to add an edge if it doesn't create a cycle
        public boolean addEdge(int start, int end) {
            // Temporarily add the edge
            adjacencyList.get(start).add(end);
            // Check if the graph has a cycle
            if (hasCycle()) {
                // Remove the edge if it creates a cycle
                adjacencyList.get(start).remove((Integer) end);
                return false;
            }
            return true;
        }

        // Method to check if the graph has a cycle
        private boolean hasCycle() {
            boolean[] visited = new boolean[vertices];
            boolean[] recursionStack = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                if (detectCycle(i, visited, recursionStack)) {
                    return true;
                }
            }
            return false;
        }

        // Helper method to detect cycle using DFS
        private boolean detectCycle(int node, boolean[] visited, boolean[] recursionStack) {
            if (recursionStack[node]) {
                return true;
            }
            if (visited[node]) {
                return false;
            }

            visited[node] = true;
            recursionStack[node] = true;

            List<Integer> neighbors = adjacencyList.get(node);
            for (Integer neighbor : neighbors) {
                if (detectCycle(neighbor, visited, recursionStack)) {
                    return true;
                }
            }

            recursionStack[node] = false;
            return false;
        }

        // Method to print the graph (for debugging)
        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                System.out.print("Vertex " + i + ":");
                for (Integer neighbor : adjacencyList.get(i)) {
                    System.out.print(" -> " + neighbor);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        System.out.println(graph.addEdge(0, 1)); // Output: true
        System.out.println(graph.addEdge(1, 2)); // Output: true
        System.out.println(graph.addEdge(2, 3)); // Output: true
        System.out.println(graph.addEdge(3, 4)); // Output: true
        System.out.println(graph.addEdge(4, 0)); // Output: false (creates a cycle)
        System.out.println(graph.addEdge(4, 1)); // Output: false (creates a cycle)
        System.out.println(graph.addEdge(1, 3)); // Output: true

        graph.printGraph();
    }
}

