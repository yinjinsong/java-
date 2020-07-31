public class Num67把字符串转换成整数重要 {
    public int strToInt(String str) {
        char[] arr = str.trim().toCharArray();
        int index = 0, ans = 0, sign = 1;
        if (index == arr.length) return 0;
        if (arr[index] == '+' || arr[index] == '-') {
            if (arr[index] == '-') sign = -1;
            index++;
        }
        while (index < arr.length) {
            char c = arr[index];
            if (!Character.isDigit(c)) break;
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && c - '0' > 7) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && c - '0' > 8) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + (c - '0') * sign;
            index++;
        }
        return ans;
    }
}
