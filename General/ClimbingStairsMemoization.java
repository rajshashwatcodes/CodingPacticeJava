import java.util.Arrays;

public class ClimbingStairsMemoization {
    
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsHelper(n, memo);
    }

    public static int climbStairsHelper(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int numStairs = 5;
        int waysToClimb = climbStairs(numStairs);
        System.out.println("Number of ways to climb " + numStairs + " stairs: " + waysToClimb);
    }
}
