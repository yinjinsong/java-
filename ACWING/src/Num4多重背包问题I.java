import java.util.Scanner;

public class Num4多重背包问题I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dp = new int[m + 1];
        int[] weight = new int[n];
        int[] value = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
            count[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= count[i]; k++) {
                    if (j >= k * weight[i]) {
                        dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                    }
                }
            }
        }
        System.out.println(dp[m]);
    }
}
