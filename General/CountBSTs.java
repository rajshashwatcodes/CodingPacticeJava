public class CountBSTs {
    public static int countBSTs(int n) {
        // Create an array to store the number of BSTs for each size
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // Empty tree
        dp[1] = 1; // Single node tree
        
        // Calculate the number of BSTs for each size using dynamic programming
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of BSTs with " + n + " nodes: " + countBSTs(n));
    }
}
