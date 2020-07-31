package 力扣刷题;

//实现strStr
public class Num28 {
    public static void main(String[] args) {

    }

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        //暴力法
        int i = 0;
        int j = 0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == target.length()) {
            //起始位置
            return i - j;
        } else {
            return -1;
        }

    }
}
