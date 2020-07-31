package 力扣刷题;

public class Num5最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        String ans = String.valueOf(s.charAt(0));
        //初始单个字符
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //初始化相邻的
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                maxLen = 2;
                ans = s.substring(i, i + 2);
            }
        }
        //状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

}
