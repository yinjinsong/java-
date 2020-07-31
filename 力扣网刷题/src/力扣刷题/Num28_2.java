package 力扣刷题;

public class Num28_2 {
    public static void main(String[] args) {
        System.out.println(strStr("abbcd", "bcd"));
    }

    public static int strStr(String source, String target) {
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

}
