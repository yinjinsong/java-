public class Num0801三步问题 {
    public int waysToStep(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int[] floors = new int[]{1, 2, 3};
        for (int i = 3; i <= n; i++) {
            for (int floor : floors) {
                dp[i] = (dp[i] + dp[i - floor]) % 1000000007;
            }
        }
        return dp[n];
    }
}
