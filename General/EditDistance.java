public class EditDistance {
    
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a DP table to store the minimum edit distance
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the DP table
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        
        // Return the minimum edit distance (bottom-right cell of the DP table)
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        
        int minEditDistance = minDistance(word1, word2);
        System.out.println("Minimum edit distance between \"" + word1 + "\" and \"" + word2 + "\" is: " + minEditDistance);
    }
}
