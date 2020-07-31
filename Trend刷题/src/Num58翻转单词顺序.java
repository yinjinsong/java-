public class Num58翻转单词顺序 {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                sb.append(s1[i] + " ");
            }
        }
        if(sb.length()==0) return "";
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public String reverseWords2(String s) {
        String trim = s.trim();
        StringBuilder sb = new StringBuilder();
        int i = trim.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && trim.charAt(i) != ' ') i--;
            String s1 = trim.substring(i + 1, j + 1);
            sb.append(s1 + " ");
            while (i >= 0 && trim.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}
