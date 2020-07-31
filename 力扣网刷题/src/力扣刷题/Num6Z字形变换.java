package 力扣刷题;

public class Num6Z字形变换 {

    public  String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            //第一行或者最后一行
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j += 2 * (numRows - 1)) {
                    ans.append(s.charAt(j));
                }
            } else {
                for (int j = i, k = 2 * (numRows - 1) - i;
                     j < s.length() || k < s.length();
                     j += 2 * (numRows - 1), k += 2 * (numRows - 1)) {
                    if (j < s.length()) ans.append(s.charAt(j));
                    if (k < s.length()) ans.append(s.charAt(k));
                }
            }
        }
        return ans.toString();
    }
}
