public class LongestIncreasingSubsequence {

    // Method to find the length of the longest increasing subsequence using dynamic programming
    public static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
            if (lis[i] > max) {
                max = lis[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("The length of the longest increasing subsequence is: " + longestIncreasingSubsequence(nums));
    }
}
