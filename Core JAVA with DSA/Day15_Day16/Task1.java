package Day15_Day16;

public class Task1 {

    // Function to determine the maximum value of items that can fit into the knapsack
    public int Knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp table in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        int W = 50; // Capacity of the knapsack
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};

        System.out.println("Maximum value in Knapsack = " + task.Knapsack(W, weights, values));
    }
}

