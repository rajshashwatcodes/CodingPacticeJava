public class ClimbingStairs {
    
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int numStairs = 5;
        int waysToClimb = climbStairs(numStairs);
        System.out.println("Number of ways to climb " + numStairs + " stairs: " + waysToClimb);
    }
}
