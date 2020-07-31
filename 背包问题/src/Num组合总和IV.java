public class Num组合总和IV {
    public int backPackVI(int[] nums, int m) {
        //dp[i]代表前能拼出重量为i的方式总数
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            dp[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[m];
    }


}
