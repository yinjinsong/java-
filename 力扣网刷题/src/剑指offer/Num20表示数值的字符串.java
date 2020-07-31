package 剑指offer;

public class Num20表示数值的字符串 {
    public static void main(String[] args) {
        System.out.println(isNumber(" -."));
    }
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] arr = s.trim().toCharArray();
        if (arr.length == 0) {
            return false;
        }
        int index = 0;
        if (arr[index] == '+' || arr[index] == '-') {
            index++;
        }
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (index < arr.length) {
            char c = arr[index];
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || num == false) {
                    return false;
                }
                exp = true;
                //重置num
                num = false;
            } else if (c == '+' || c == '-') {
                if (arr[index - 1] != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            index++;
        }
        return num;
    }

}
