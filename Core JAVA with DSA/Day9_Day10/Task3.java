package Day9_Day10;

import java.util.*;

class Task3 {

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(parent, -1); // Initialize each node as its own parent (disjoint set)
        }

        // Find with path compression
        public int find(int vertex) {
            if (parent[vertex] == -1) {
                return vertex;
            } else {
                // Path compression: Flatten the structure for faster future queries
                parent[vertex] = find(parent[vertex]);
                return parent[vertex];
            }
        }

        // Union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                // Union by rank: Attach smaller tree under root of larger tree
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

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

        // Method to check if the graph has a cycle using Union-Find
        public boolean hasCycle() {
            UnionFind uf = new UnionFind(vertices);

            for (int i = 0; i < vertices; i++) {
                for (int neighbor : adjacencyList.get(i)) {
                    int rootX = uf.find(i);
                    int rootY = uf.find(neighbor);

                    if (rootX == rootY) {
                        return true; // Cycle detected
                    }

                    uf.union(rootX, rootY);
                }
            }

            return false; // No cycle detected
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Add an edge that creates a cycle
        graph.addEdge(4, 0);

        System.out.println("Graph has cycle: " + graph.hasCycle()); // Output: true
    }
}

