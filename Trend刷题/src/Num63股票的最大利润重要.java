public class Num63股票的最大利润重要 {
    public int maxProfit(int[] prices) {
        //记录最小花费，和最大利润
        if(prices.length<2) return 0;
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
