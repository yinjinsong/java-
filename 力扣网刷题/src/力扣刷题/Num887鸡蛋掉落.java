package 力扣刷题;

public class Num887鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        //dp[i][j]代标前i个鸡蛋确定j层高度的最小次数
        int[][] dp = new int[K + 1][N + 1];
        //初始化
        //只有一个鸡蛋需要扔N次才能确定
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                int min = N * N;
                for (int j = 1; j <= N; j++) {
                    int tempMin = Math.max(dp[K - 1][j - 1], dp[K][N - j]) + 1;
                    min = Math.min(tempMin, min);
                }
                dp[K][i] = min;
            }
        }
        return dp[K][N];
    }


}

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] middleResults = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            middleResults[1][i] = i; // only one egg
            middleResults[0][i] = 0; // no egg
        }
        for (int i = 1; i <= K; i++) {
            middleResults[i][0] = 0; // zero floor
        }

        for (int k = 2; k <= K; k++) { // start from two egg
            for (int n = 1; n <= N; n++) {
                int tMinDrop = N * N;
                for (int x = 1; x <= n; x++) {
                    tMinDrop = Math.min(tMinDrop, 1 + Math.max(middleResults[k - 1][x - 1], middleResults[k][n - x]));
                }
                middleResults[k][n] = tMinDrop;
            }
        }

        return middleResults[K][N];
    }
}

