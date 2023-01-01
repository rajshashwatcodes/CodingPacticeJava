class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i <= nums.length;i++){
            int cur_val = 0;
            for (int j = i; j < nums.length; j++){
                cur_val += nums[j];
                if (ans < cur_val)
                    ans = cur_val;
            }
        }
        return ans;
    }
}
