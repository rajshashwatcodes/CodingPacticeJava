import java.util.HashMap;

public class LargestSubarrayWithSumZero {

    public static int[] findLargestSubarrayWithSumZero(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int endIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] == 0 && maxLength == 0) {
                maxLength = 1;
                endIndex = i;
            }

            if (sum == 0) {
                maxLength = i + 1;
                endIndex = i;
            }

            if (sumIndexMap.containsKey(sum)) {
                int prevIndex = sumIndexMap.get(sum);
                if (i - prevIndex > maxLength) {
                    maxLength = i - prevIndex;
                    endIndex = i;
                }
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        if (maxLength > 0) {
            int[] result = new int[maxLength];
            System.arraycopy(nums, endIndex - maxLength + 1, result, 0, maxLength);
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] result = findLargestSubarrayWithSumZero(nums);

        System.out.println("Largest subarray with sum 0:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
