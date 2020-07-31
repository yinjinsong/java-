package 力扣刷题;//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        给定一个只包含数字的非空字符串，请计算解码方法的总数。

public class Num91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("02"));
    }

    //考虑最后一个状态，只可能加一位（1-9）或者加两位（10-26）
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }

            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[s.length()];
    }
}
