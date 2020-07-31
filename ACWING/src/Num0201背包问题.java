import java.util.Scanner;

public class Num0201背包问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= weight[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        System.out.println(dp[m]);
        
    }
}
