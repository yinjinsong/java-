public class Num10斐波那契数列 {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        if(n<2) return n;
        dp[0] = 0; dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
    //滚动数组优化空间O(3)
    public int fib2(int n) {
        int[] dp = new int[n + 1];
        if(n<2) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i < n + 1; i++) {
            c = (a + b)% 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
