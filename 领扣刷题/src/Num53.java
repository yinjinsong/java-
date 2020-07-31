/*
给定一个字符串，逐个翻转字符串中的每个单词。

样例
样例  1:
	输入:  "the sky is blue"
	输出:  "blue is sky the"

	样例解释:
	返回逐字反转的字符串.

样例 2:
	输入:  "hello world"
	输出:  "world hello"

	样例解释:
	返回逐字反转的字符串.

说明
单词的构成：无空格字母构成一个单词，有些单词末尾会带有标点符号
输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 */
public class Num53 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  Life  doesn't  always    give     us  the       joys we want."));
    }
    public static String reverseWords(String s) {
        String trim = s.trim();
        if (trim.length() == 0) {
            return s;
        }

        String[] s1 = trim.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                if (i != 0) {
                    sb.append(s1[i] + " ");
                } else {
                    sb.append(s1[i]);
                }
            }

        }

        return sb.toString();
    }

}
