package 力扣刷题;

public class Num151翻转字符串里的单词 {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        int left = s.length() - 1;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            while (left>=0&&s.charAt(left)!=' ') left--;
            String t = s.substring(left + 1, right + 1) + " ";
            sb.append(t);
            while (left>=0&&s.charAt(left)==' ') left--;
            right = left;
        }
        return sb.toString().trim();
    }
}
