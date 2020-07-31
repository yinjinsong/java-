package 力扣刷题;

public class Num213打家劫舍II {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }
    //遇环拆环，分取头和取尾两种情况
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        //1.拆环，偷取第一家就不能偷取最后一家
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length ; i++) {
            if (i != nums.length) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int ans = dp[nums.length];
        //2.不偷第一家，偷最后一家
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        if (dp[nums.length] > ans) {
            ans = dp[nums.length];
        }
        return ans;
    }
}
