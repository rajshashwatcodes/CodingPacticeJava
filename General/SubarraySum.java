import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1); // Initialize with a prefix sum of 0.

        for (int num : nums) {
            currentSum += num;
            
            // Check if there is a subarray with sum (currentSum - k)
            if (sumMap.containsKey(currentSum - k)) {
                count += sumMap.get(currentSum - k);
            }

            // Update the count of currentSum in the hashmap
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;

        int[] nums2 = {1, 2, 3};
        int k2 = 3;

        System.out.println("Example 1: " + subarraySum(nums1, k1)); // Output: 2
        System.out.println("Example 2: " + subarraySum(nums2, k2)); // Output: 2
    }
}
