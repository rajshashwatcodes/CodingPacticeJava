import java.util.Arrays;

public class ClimbingStairsVariation {
    
    public static int climbStairs(int n, int k) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsHelper(n, k, memo);
    }

    public static int climbStairsHelper(int n, int k, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int ways = 0;
        for (int i = 1; i <= k && n - i >= 0; i++) {
            ways += climbStairsHelper(n - i, k, memo);
        }
        memo[n] = ways;
        return ways;
    }

    public static void main(String[] args) {
        int numStairs = 5;
        int maxSteps = 2; // Maximum number of steps you can take at a time
        int waysToClimb = climbStairs(numStairs, maxSteps);
        System.out.println("Number of ways to climb " + numStairs + " stairs with maximum " + maxSteps + " steps at a time: " + waysToClimb);
    }
}
