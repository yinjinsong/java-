package 七月每日一题;
/*
给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
样例
样例 1：

输入:
"aabcc"
"dbbca"
"aadbbcbcac"
输出:
true
样例 2：

输入:
""
""
"1"
输出:
false
样例 3：

输入:
"aabcc"
"dbbca"
"aadbbbaccc"
输出:
false
 */
public class IsInterleave {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        //这一题需要记录s1的当前位置和s2的当前位置
        //dp[i][j]代表s3可以被s1的前i个字母和s2的前j个字母所组成
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        //状态转移
        //需要判断dp[i-1][j]为true且s1的第i个位置等于s3的下一个位置
        //或者dp[i][j-1]为true且s2的第j个位置等于s3的下一个位置
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {

                    dp[i][j] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];


    }
}
