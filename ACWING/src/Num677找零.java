import java.util.Scanner;

public class Num677找零 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        n = 1024 - n;
        int[] coins = {64, 16, 4, 1};
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            ans += n / coins[i];
            n %= coins[i];
        }
        System.out.println(ans);
    }
}
