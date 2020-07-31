public class Num0105一次编辑 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n] <= 1;
    }

    public boolean oneEditAway2(String first, String second) {
        if(Math.abs(first.length()-second.length())>1) return false;
        return dfs(first.toCharArray(), 0, second.toCharArray(), 0, 0);
    }

    private boolean dfs(char[] s, int index1, char[] p, int index2, int count) {
        if(count>1) return false;
        if(index1==s.length&&index2==p.length) return true;
        if(s[index1]!=p[index2])
            return dfs(s, index1 + 1, p, index2, count + 1) || dfs(s, index1, p, index2 + 1, count + 1);
        else return dfs(s, index1 + 1, p, index2 + 1, count);
    }

}
