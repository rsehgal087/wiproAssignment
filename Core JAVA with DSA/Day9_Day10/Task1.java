package Day9_Day10;

import java.util.*;

class Task1 {

    static class Graph {
        private int vertices;
        private List<List<Node>> adjacencyList;

        static class Node {
            int vertex;
            int weight;

            Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        // Method to add an edge to the graph
        public void addEdge(int start, int end, int weight) {
            adjacencyList.get(start).add(new Node(end, weight));
            adjacencyList.get(end).add(new Node(start, weight)); // For undirected graph
        }

        // Dijkstra's algorithm to find the shortest path from a start node
        public void dijkstra(int start) {
            PriorityQueue<Node> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(node -> node.weight));
            int[] dist = new int[vertices];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();
                int currentVertex = currentNode.vertex;

                for (Node neighbor : adjacencyList.get(currentVertex)) {
                    int newDist = dist[currentVertex] + neighbor.weight;

                    if (newDist < dist[neighbor.vertex]) {
                        dist[neighbor.vertex] = newDist;
                        pq.add(new Node(neighbor.vertex, newDist));
                    }
                }
            }

            // Print the shortest distances
            printShortestDistances(dist);
        }

        // Method to print the shortest distances
        private void printShortestDistances(int[] dist) {
            System.out.println("Vertex\t\tDistance from Source");
            for (int i = 0; i < dist.length; i++) {
                System.out.println(i + "\t\t" + dist[i]);
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

        System.out.println("Dijkstra's Algorithm:");
        graph.dijkstra(0);
    }
}

