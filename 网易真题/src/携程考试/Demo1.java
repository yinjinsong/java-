package 携程考试;

import java.util.Scanner;
/*
小明在凌空SOHO上班，想通过爬楼梯的方式锻炼。他爬楼梯的方式有3种，
一步跨一层、一步跨二层或一步跨三层，但是由于身体原因，在爬楼梯的锻炼中，
一步跨三层的方式只能使用一次，请问爬到第K层楼梯时共有多少种方式？
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //dp[i]表示只用一步或者两步走到底i层的总共方法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else {
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            int ans = dp[n];
            //枚举3所在的位置
            for (int i = 3; i <= n; i++) {
                ans += dp[i - 3] * dp[n - i];
            }
            System.out.println(ans);
        }
    }
}
