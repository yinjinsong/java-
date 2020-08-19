package 广联达;

import java.util.Arrays;
import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 5, 10, 50, 100};
        Scanner scanner = new Scanner(System.in);
        int[] count = new int[5];
        for (int i = 0; i < 5; i++) {
            count[i] = scanner.nextInt();
        }
        int amount = scanner.nextInt();
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 10);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = amount; j >= 0; j--) {
                int time = count[i];
                for (int k = 0; k < time; k++) {
                    if (j >= k * coins[i]) {
                        dp[j] = Math.min(dp[j], dp[j - k * coins[i]] + k);
                    }
                }
            }
        }
        System.out.println(dp[amount] > amount ? -1 : dp[amount]);
    }
}
