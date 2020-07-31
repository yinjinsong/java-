public class Num397最长连续上升子序列 {
    public static void main(String[] args) {
        System.out.println(longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3}));
    }
    public static int longestIncreasingContinuousSubsequence(int[] A) {
        //从左到右上升
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        int ans = 0;
        //初始化
        dp[0] = 1;
        //状态转移
        for (int i = 0; i < A.length; i++) {
            dp[i] = 1;
            if (i > 0 && A[i] > A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }

        //从左到右下降
        for (int i = 0; i < A.length; i++) {
            dp[i] = 1;
            if (i > 0 && A[i] < A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
