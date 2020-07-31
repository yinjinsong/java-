package 力扣刷题;

public class Num131分割回文串 {
//    public List<List<String>> partition(String s) {
//
//    }

    private boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean[][] dp = new boolean[len][len];
        //初始化单个元素
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //初始化相邻元素
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                dp[i - 1][i] = true;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j];
            }
        }
        return dp[len - 1][len - 1];
    }
}
