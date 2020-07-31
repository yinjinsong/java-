package 力扣刷题;

public class Num123买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxK = 2;
        //dp[i][k][m]分别代表第几天，剩余买入机会，有股票和无股票状态
        int[][][] dp = new int[prices.length][maxK + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    //初始化情况
                    //1.未持有股票收益是0
                    dp[i][k][0] = 0;
                    //2.还没开始不可能持有股票，初始化成一个负数表示不可能
                    dp[i][k][1] = -prices[1];
                } else {
                    //状态转移情况
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        return dp[prices.length - 1][maxK][0];
    }
}
