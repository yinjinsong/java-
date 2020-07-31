public class Num60n个骰子的点数重要 {
    public double[] twoSum(int n) {
        //dp[i][j]代表前i个骰子掷出j点数的次数和
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= i - 1) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        double totalCount = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = dp[n][i] / totalCount;
        }
        return ans;
    }

    public double[] twoSum2(int n) {
        double[] ans = new double[5 * n + 1];
        double totalCount = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = dfs(n, i) / totalCount;
        }
        return ans;

    }

    private double dfs(int n, int sum) {
       if(sum<0) return 0;
       if(n==0) return sum == 0 ? 1 : 0;
        double ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans += dfs(n - 1, sum - i);
        }
        return ans;
    }
}
