public class FriendsPairing {

    // Function to calculate the total number of ways friends can remain single or be paired up
    public static int countWays(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        
        // Base cases
        dp[1] = 1;
        dp[2] = 2;

        // Fill the dp array using the recurrence relation
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4; // Replace with the number of friends
        int result = countWays(n);
        
        System.out.println("Total number of ways: " + result);
    }
}
