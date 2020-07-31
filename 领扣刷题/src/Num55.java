/*
比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母

样例
给出 A = "ABCD" B = "ACD"，返回 true

给出 A = "ABCD" B = "AABC"， 返回 false

注意事项
在 A 中出现的 B 字符串里的字符不需要连续或者有序。
 */
public class Num55 {
    public static void main(String[] args) {

    }
    public static boolean compareStrings(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        char[] strA = A.toCharArray();
        char[] strB = B.toCharArray();

        //代表26个字母每个字母出现的次数
        int[] counts = new int[26];
        for (int i = 0; i < strA.length; i++) {
            counts[strA[i] - 'A']++;
        }
        for (int i = 0; i < strB.length; i++) {
            counts[strB[i] - 'A']--;
            if (counts[strB[i] - 'A'] < 0) {
                return false;
            }
        }
        return true;

    }
}
