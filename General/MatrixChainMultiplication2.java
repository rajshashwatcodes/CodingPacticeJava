public class MatrixChainMultiplication2 {
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n];
        
        // Initialize the diagonal elements with 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        
        // Outer loop for chain length
        for (int chainLength = 2; chainLength < n; chainLength++) {
            // Inner loop for starting index of chain
            for (int i = 1; i < n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                dp[i][j] = Integer.MAX_VALUE;
                // Iterate over partition points
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        // Return the minimum number of multiplications for the entire chain
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 30, 5, 60};
        int minMultiplications = matrixChainOrder(dimensions);
        System.out.println("Minimum number of multiplications needed: " + minMultiplications);
    }
}
