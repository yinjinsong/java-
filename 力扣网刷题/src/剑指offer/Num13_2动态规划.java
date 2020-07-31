package 剑指offer;

public class Num13_2动态规划 {
    public int movingCount(int m, int n, int k) {
        //状态dp[i][j]代表第ij个格子是否能走到
        boolean[][] dp = new boolean[m][n];
        //初始化
        dp[0][0] = isValid(0, 0, k);
        //转移方程
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = isValid(i, j, k) && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = isValid(i, j, k) && dp[i - 1][j];
                } else {
                    dp[i][j] = isValid(i, j, k) && (dp[i - 1][j] || dp[i][j - 1]);
                }
            }
        }
        //统计
        int count = 0;
        for (boolean[] booleans : dp) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    count++;
                }
            }
        }
        return count;


    }

    private boolean isValid(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }

}
