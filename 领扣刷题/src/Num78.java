/*
给k个字符串，求出他们的最长公共前缀(LCP)

样例
样例 1:
	输入:  "ABCD", "ABEF", "ACEF"
	输出:  "A"


样例 2:
	输入: "ABCDEFG", "ABCEFG" and "ABCEFA"
	输出:  "ABC"
 */
public class Num78 {

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"ABCD", "ABEF", "ACEF"});
    }
    public static String longestCommonPrefix(String[] strs) {
        //两两字符串进行比较，选出最长的prefix然后将prefix保存向后比较。比较到之后一个就是结果
        if (strs == null || strs.length == 0) {
            return "";
        }
        String preStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < preStr.length() && j < strs[i].length() && preStr.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            preStr = preStr.substring(0, j);
        }
        return preStr;
    }



}
