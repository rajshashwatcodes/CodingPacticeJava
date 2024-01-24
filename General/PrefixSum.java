public class PrefixSum {

    public static int[] calculatePrefixSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        // Calculate prefix sum
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return prefixSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        int[] prefixSum = calculatePrefixSum(nums);

        // Example: Print the prefix sum array
        System.out.println("Prefix Sum Array:");
        for (int sum : prefixSum) {
            System.out.print(sum + " ");
        }
    }
}
