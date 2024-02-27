import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence2 {
    
    public static List<Integer> longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }
        
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[endIndex]);
        int len = maxLength - 1;

        for (int i = endIndex - 1; i >= 0 && len > 0; i--) {
            if (dp[i] == len && nums[i] < lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
                len--;
            }
        }

        return reverseList(lis);
    }
    
    private static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        
        List<Integer> lis = longestIncreasingSubsequence(nums);
        int lisLength = lis.size();
        
        System.out.println("Length of the longest increasing subsequence: " + lisLength);
        System.out.println("Longest increasing subsequence: " + lis);
    }
}
