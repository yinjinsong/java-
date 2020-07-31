public class Num516房屋染色II {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][i];
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i - 1][k] + costs[i][j], dp[i][j]);
                    }
                }
            }
        }
        //在最后一栋房子中选取最小值
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i] < ans) {
                ans = dp[m - 1][i];
            }
        }
        return ans;

    }
}
