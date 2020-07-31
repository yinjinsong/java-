public class Num92背包问题 {
    public int backPack(int m, int[] A) {
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - A[i - 1]];
                }
            }
        }
        int ans = 0;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
