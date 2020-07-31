public class Num5最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        int maxLen = 1;
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        //初始化单个字符
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans = s.substring(i, i + 1);
        }
        //初始化相邻字符
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (arr[i] == arr[i + 1]);
            if (dp[i][i + 1]) {
                maxLen = 2;
                ans = s.substring(i, i + 2);
            }
        }
        //状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j];
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}
