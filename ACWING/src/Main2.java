import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = test(a, b);
        System.out.println(sum);
    }
    private static int test(int a, int b) {
        int n, len;
        if((a*b)%2==1) return 0;
        else if (a % 2 == 1) {
            n = b / 2;
            len = a;
        } else {
            n = a / 2;
            len = b;
        }
        int[] dp = new int[len + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= len; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }
        int sum = (int) Math.pow(dp[len], n);
        return sum;
    }
}
