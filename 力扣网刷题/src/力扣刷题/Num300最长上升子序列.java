package 力扣刷题;

public class Num300最长上升子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 1;
        int p = 0;
        int[] dp = new int[nums.length];
        int[] pi = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //存储更新后的下标到pi数组中作为藤
                    if (dp[j] + 1 == dp[i]) {
                        pi[i] = j;
                    }

                }
            }
            ans = Math.max(ans, dp[i]);
            //更新结果才记录
            if (dp[i] == ans) {
                p= i;
            }
        }
        int[] seq = new int[ans];
        for (int i = ans - 1; i >= 0; i--) {
            seq[i] = nums[p];
            p = pi[p];
        }
        for (int i = 0; i < ans; i++) {
            System.out.println(seq[i]);
        }
        return ans;

    }

}
