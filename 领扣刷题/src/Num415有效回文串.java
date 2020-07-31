/*
给定一个字符串，判断其是否为一个回文串。只考虑字母和数字，忽略大小写。

样例
样例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
解释: "amanaplanacanalpanama"
样例 2:

输入: "race a car"
输出: false
解释: "raceacar"
挑战
O(n) 时间复杂度，且不占用额外空间。

注意事项
你是否考虑过，字符串有可能是空字符串？这是面试过程中，面试官常常会问的问题。

在这个题目中，我们将空字符串判定为有效回文。
 */
public class Num415有效回文串 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        char[] arr = sb.toString().toCharArray();
        int n = arr.length;
        if (n == 0) {
            return true;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n-1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1];
        }
        for (int i = n-1; i >=0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j];
            }
        }
        return dp[0][n - 1];
    }


}
