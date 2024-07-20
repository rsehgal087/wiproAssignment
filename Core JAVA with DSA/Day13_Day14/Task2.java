package Day13_Day14;

public class Task2 {

    // Function to find the minimum cost to visit all cities and return to the starting city
    public int FindMinCost(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] dp = new int[n][(1 << n)];

        // Initialize dp array with -1 (indicating unvisited states)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }

        // Recursive function with memoization
        return tsp(0, 1, graph, dp, n, VISITED_ALL);
    }

    private int tsp(int currentCity, int mask, int[][] graph, int[][] dp, int n, int VISITED_ALL) {
        // If all cities are visited, return to the starting city
        if (mask == VISITED_ALL) {
            return graph[currentCity][0];
        }

        // If this state is already computed, return the result
        if (dp[currentCity][mask] != -1) {
            return dp[currentCity][mask];
        }

        int minCost = Integer.MAX_VALUE;

        // Try to visit all unvisited cities and take the minimum cost path
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if ((mask & (1 << nextCity)) == 0) { // Check if the city is unvisited
                int newCost = graph[currentCity][nextCity] + tsp(nextCity, mask | (1 << nextCity), graph, dp, n, VISITED_ALL);
                minCost = Math.min(minCost, newCost);
            }
        }

        // Memoize the result
        dp[currentCity][mask] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        System.out.println("The minimum cost to visit all cities is: " + task2.FindMinCost(graph));
    }
}
