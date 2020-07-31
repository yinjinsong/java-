import java.util.Arrays;

public class Demo {
    /*
        任何一个正整数，可以分解成若干个完全平方数之和。
        给定正整数n，如何分解使得完全平方数的个数最少，给出个数。
     */
    public static void main(String[] args) {
        System.out.println(SquareNum(100));
    }

    /**
     *
     * @param n 给定整数
     * @return 最少平方和个数
     */
    public static int SquareNum(int n) {
        //动态规划
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
