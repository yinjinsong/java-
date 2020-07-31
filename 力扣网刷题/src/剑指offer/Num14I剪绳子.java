package 剑指offer;

public class Num14I剪绳子 {
    public static void main(String[] args) {
        System.out.println(cuttingRope2(100));
    }

    //长度取3是最优的，数学推导
    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        int count = n / 3;
        int ans = 0;
        if (n % 3 == 0) {
            ans = (int) Math.pow(3, count);
        } else if (n % 3 == 1) {
            ans = (int) Math.pow(3, count - 1) * 4;
        } else {
            ans = (int) Math.pow(3, count) * 2;
        }
        return ans;
    }

    //记忆化搜索（自顶向下)
    public static int cuttingRope2(int n) {
        dp = new int[n + 1];
        return helper(n);
    }

    private static int[] dp;

    public static int helper(int n) {
        if (n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = -1;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.max(i * (n - i), i * helper(n - i)));
        }
        dp[n] = ans;
        return ans;

    }

    //动态规划
    public int cuttingRope3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }



}
