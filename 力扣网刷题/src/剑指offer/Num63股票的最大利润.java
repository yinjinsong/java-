package 剑指offer;

public class Num63股票的最大利润 {
    public static void main(String[] args) {
        maxProfit(new int[]{1,2});
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] arr = new int[prices.length - 1];
        //求出间隔，题目即转化成求最大连续子串和
        for (int i = 0; i < prices.length - 1; i++) {
            arr[i] = prices[i + 1] - prices[i];
        }
        int[] dp = new int[arr.length];
        dp[0] = Math.max(arr[0], 0);
        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            ans = ans > dp[i] ? ans : dp[i];
        }
        return ans;
    }

    //当前值减去前面天数中的最小值
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
