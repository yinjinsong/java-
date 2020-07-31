public class Num512解码方法 {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length + 1];
        dp[0] = 1;
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                int val = (arr[i - 2] - '0') * 10 + arr[i - 1] - '0';
                if (val >= 10 && val <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[arr.length];
    }

}
