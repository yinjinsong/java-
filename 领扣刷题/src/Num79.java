/*
最长公共子串
样例 1:
	输入:  "ABCD" and "CBCE"
	输出:  2

	解释:
	最长公共子串是 "BC"


样例 2:
	输入: "ABCD" and "EACB"
	输出:  1

	解释:
	最长公共子串是 'A' 或 'C' 或 'B'
挑战
O(n x m) time and memory.
 */
public class Num79 {
    public static void main(String[] args) {

    }
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        //暴力法 枚举A的所有substr
        int maxLen = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j <= A.length(); j++) {
                String str = A.substring(i, j);
                if (str.length() > maxLen && B.contains(str)) {
                    maxLen = str.length();
                }
            }
        }
        return maxLen;

    }

//    public int longestCommonSubstring2(String A, String B) {
//        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
//            return 0;
//        }
//        //动态规划
//        dp[i][j]
//
//    }


}
