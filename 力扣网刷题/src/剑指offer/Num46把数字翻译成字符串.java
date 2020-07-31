package 剑指offer;

public class Num46把数字翻译成字符串 {
    //dp
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            String substring = s.substring(i - 2, i);
            if (substring.compareTo("10") >= 0 && substring.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];

    }
}
