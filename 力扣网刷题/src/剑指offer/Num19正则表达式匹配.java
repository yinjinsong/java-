package 剑指offer;

public class Num19正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (pp[j - 1] != '*') {
                    if (i > 0 && ss[i - 1] == pp[j - 1] || pp[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (j > 1) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                    if (i > 0 && (pp[j - 2] == '.' || ss[i - 1] == pp[j - 2])) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }

        }
        return dp[s.length()][p.length()];
    }
}
