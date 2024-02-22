public class UnboundedKnapsack {
    
    public static int unboundedKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j < n; j++) {
                if (weights[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
                }
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] values = {10, 40, 50, 70};
        int[] weights = {1, 3, 4, 5};
        int capacity = 8;
        
        int maxValue = unboundedKnapsack(values, weights, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
