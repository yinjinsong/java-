public class Num19正则表达式匹配重点 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //dp[i][j]代表s的前i个字符和p的前j个字符是否匹配
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    if (p.charAt(j - 1) != '*') {
                        if (i >= 1 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] |= dp[i - 1][j - 1];
                        }
                    } else {
                        //不看
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
