package 剑指offer;

public class Num60n个骰子的点数 {
    public double[] twoSum(int n) {
        //状态：dp[i][j]代表投完i个骰子后点数和为j的次数总和
        int[][] dp = new int[n + 1][6 * n + 1];
        //初始化：
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //状态转移
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    //i-1个骰子的点数和必须大于等于i-1
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];

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
        for (int i = n; i <= 6 * n; i++) ans[i - n] = dfs(n, i) / Math.pow(6, n);
        return ans;
    }

    private double dfs(int n, int sum) {
        if(sum<0) return 0;
        if(n==0) return sum == 0 ? 1 : 0;
        double res = 0;
        for (int i = 1; i <= 6; i++) {
            res += dfs(n - 1, sum - i);
        }
        return res;
    }
}
