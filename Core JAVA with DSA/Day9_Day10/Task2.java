package Day9_Day10;

import java.util.*;

class Task2 {

    static class Graph {
        private int vertices;
        private List<Edge> edges;

        static class Edge {
            int src, dest, weight;

            Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }

        public Graph(int vertices) {
            this.vertices = vertices;
            edges = new ArrayList<>();
        }

        // Method to add an edge to the graph
        public void addEdge(int src, int dest, int weight) {
            edges.add(new Edge(src, dest, weight));
        }

        // Find function of Disjoint Set
        private int find(int[] parent, int vertex) {
            if (parent[vertex] == -1)
                return vertex;
            return find(parent, parent[vertex]);
        }

        // Union function of Disjoint Set
        private void union(int[] parent, int x, int y) {
            int rootX = find(parent, x);
            int rootY = find(parent, y);
            parent[rootX] = rootY;
        }

        // Kruskal's algorithm to find MST
        public List<Edge> kruskalMST() {
            List<Edge> mst = new ArrayList<>();
            // Step 1: Sort all the edges in non-decreasing order of their weight
            edges.sort(Comparator.comparingInt(e -> e.weight));

            int[] parent = new int[vertices];
            Arrays.fill(parent, -1);

            int edgeCount = 0;
            int index = 0;

            // Step 2: Iterate through all edges in sorted order and add to MST if they don't form a cycle
            while (edgeCount < vertices - 1 && index < edges.size()) {
                Edge nextEdge = edges.get(index++);

                int rootSrc = find(parent, nextEdge.src);
                int rootDest = find(parent, nextEdge.dest);

                // If including this edge does not cause a cycle, include it in the MST
                if (rootSrc != rootDest) {
                    mst.add(nextEdge);
                    union(parent, rootSrc, rootDest);
                    edgeCount++;
                }
            }

            return mst;
        }

        // Method to print the MST
        public void printMST(List<Edge> mst) {
            System.out.println("Minimum Spanning Tree edges:");
            for (Edge edge : mst) {
                System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.addEdge(2, 4, 5);

        List<Graph.Edge> mst = graph.kruskalMST();
        graph.printMST(mst);
    }
}

