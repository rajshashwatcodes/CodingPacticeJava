public class MinimumPartitioning2 {
    public static int minPartition(int[] arr) {
        int n = arr.length;
        
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Create a 2D array to store the subset sum possibilities
        boolean[][] dp = new boolean[n + 1][totalSum + 1];
        
        // Initialize the first column as true since sum 0 is possible for any subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Fill the dp array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        // Find the minimum partition difference
        int minDiff = Integer.MAX_VALUE;
        for (int j = totalSum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = totalSum - 2 * j;
                break;
            }
        }
        
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int minPartition = minPartition(arr);
        System.out.println("Minimum partition difference: " + minPartition);
    }
}
