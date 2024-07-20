package Day15_Day16;

public class Task2 {
    
    public int LCS(String text1, String text2) {
        int m = text1.length();
        int t = text2.length();
        
        int[][] dp = new int[m + 1][t + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= t; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][t];
    }

    public static void main(String[] args) {
        Task2 task = new Task2();
        String text1 = "abcde";
        String text2 = "acde";
        System.out.println("Length of LCS: " + task.LCS(text1, text2)); // Output: 3
    }
}

