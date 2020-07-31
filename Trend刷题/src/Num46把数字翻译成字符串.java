public class Num46把数字翻译成字符串 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        //dp[i]代表前i个字符的翻译方式数
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            if (i >= 2) {
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (t >= 10 && t <= 25) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

}
