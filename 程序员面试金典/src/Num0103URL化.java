public class Num0103URL化 {
    public String replaceSpaces(String S, int length) {
        StringBuilder ans = new StringBuilder();
        char[] arr = S.toCharArray();
        int index = 0;
        for (char c : arr) {
            if (c != ' ') ans.append(c);
            else ans.append("%20");
            index++;
            if (index == length) break;
        }
        return ans.toString();
    }
}
