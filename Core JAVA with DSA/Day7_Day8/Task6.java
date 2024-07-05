package Day7_Day8;

import java.util.*;

class Task6 {

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

        // Method to add an undirected edge
        public void addEdge(int start, int end) {
            adjacencyList.get(start).add(end);
            adjacencyList.get(end).add(start);
        }

        // Method to perform DFS traversal from a given starting node
        public void dfs(int start) {
            boolean[] visited = new boolean[vertices];
            dfsUtil(start, visited);
        }

        // Recursive utility method for DFS
        private void dfsUtil(int node, boolean[] visited) {
            visited[node] = true;
            System.out.print(node + " ");

            for (Integer neighbor : adjacencyList.get(node)) {
                if (!visited[neighbor]) {
                    dfsUtil(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("DFS traversal starting from node 0:");
        graph.dfs(0); // Output: 0 1 2 3 4
    }
}

