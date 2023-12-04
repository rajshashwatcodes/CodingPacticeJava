public class MinimumPartitioning {

    public static int findMinPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // Create a 2D array to store the subset sum possibilities
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize the first column (sum = 0) to true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // Find the minimum possible difference
        int minDiff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = sum - 2 * j;
                break;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 1};
        int minPartition = findMinPartition(arr);
        System.out.println("Minimum Partition Difference: " + minPartition);
    }
}
