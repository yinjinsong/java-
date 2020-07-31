package 剑指offer;

public class Num58翻转单词顺序 {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length-1; i >=0; i--) {
            if (i != 0) {
                if (!"".equals(s1[i])) {
                    sb.append(s1[i] + " ");
                }
            } else {
                sb.append(s1[i]);
            }

        }
        return sb.toString();
    }
}
