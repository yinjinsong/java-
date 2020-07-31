package 力扣刷题;

public class Num416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        //如果是奇数必然不可能分成两部分相等的子集
        if (sum % 2 == 1) {
            return false;
        }
        //问题转换成是否存在一个子序列使得子序列的和刚好为sum/2
        //进一步说明从数组中任意选择数字能否使得他们的和刚好为sum/2

        //dp[i][j]代表选择前i个数字凑成总和为j是否可行
        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        //初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - nums[i - 1] >= 0) {
                    //和完全背包不同的是这里如果选择了i需要减1因为数量不是无限制的选择一个少一个
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
    //压缩空间
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        //如果是奇数必然不可能分成两部分相等的子集
        if (sum % 2 == 1) {
            return false;
        }
        //问题转换成是否存在一个子序列使得子序列的和刚好为sum/2
        //进一步说明从数组中任意选择数字能否使得他们的和刚好为sum/2

        //dp[i][j]代表选择前i个数字凑成总和为j是否可行
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        //初始化
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    //和完全背包不同的是这里如果选择了i需要减1因为数量不是无限制的选择一个少一个
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }
}
