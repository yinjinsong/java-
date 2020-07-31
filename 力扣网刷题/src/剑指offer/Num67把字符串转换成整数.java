package 剑指offer;

public class Num67把字符串转换成整数 {
    public int strToInt(String str) {
        char[] arr = str.toCharArray();
        //取出前置空格
        int index = 0;
        while (index < arr.length && arr[index] == ' ') {
            index++;
        }
        //如果字符串是["    "],做出判断
        if (index == arr.length) {
            return 0;
        }
        //判断符号位
        int sign = 1;
        if (arr[index] == '+' || arr[index] == '-') {
            if (arr[index] == '-') {
                sign = -1;
            }
            ++index;
        }
        //开始转换数值
        int ans = 0;
        while (index < arr.length) {
            char c = arr[index];
            if (c < '0' || c > '9') {
                break;
            }
            //判断上下界有没有溢出，需要在×10之前判断
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            //计算的时候带上符号
            ans = ans * 10 + (c - '0') * sign;
            index++;
        }
        return ans;
    }
}
