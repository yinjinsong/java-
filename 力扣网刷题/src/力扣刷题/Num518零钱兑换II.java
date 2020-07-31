package 力扣刷题;

public class Num518零钱兑换II {
    public static void main(String[] args) {
        System.out.println(change( 5,new int[]{1, 2, 5}));
    }
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        //dp[i][j]前i个硬币的值想要凑出金额j有dp[i][j]种凑法
        int[][] dp = new int[n + 1][amount + 1];
        //前i个硬币想要凑出0元只有一种方法都不选择
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    //选择当前硬币和不选择当前硬币
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                //第i个硬币装不下了，保持之前的方案
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
    //压缩状态
    //问金额不限的硬币凑出amount共有多少总凑发
    public static int change2(int amount, int[] coins) {
        int n = coins.length;
        //dp[i][j]前i个硬币的值想要凑出金额j有dp[i][j]种凑法
        int[] dp = new int[amount + 1];
        //前i个硬币想要凑出0元只有一种方法都不选择
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    //选择当前硬币和不选择当前硬币
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
}
