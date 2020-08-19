public class Num1617连续数列 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 1], nums[i - 1] + dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
