package 力扣刷题;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class Num38外观数列 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                sb.append(k - j).append(s.charAt(j));
                j = k - 1;
            }
            s = sb.toString();
        }
        return s;
    }
}























