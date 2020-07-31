public class Num664 {
    public static void main(String[] args) {
        System.out.println(countBits2(5));
    }
    //暴力法
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            while (i > 0) {
                count++;
                i &= i - 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    //dp[i]表示数字i的1的个数，dp[i]=dp[i/2]+i%2
    public static int[] countBits2(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + i % 2;
        }
        return dp;
    }


}
