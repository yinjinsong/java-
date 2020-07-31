public class Num0811硬币 {
    public int waysToChange(int m) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (j >= coins[i]) {
                    dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
                }
            }
        }
        return dp[m];
    }
}
