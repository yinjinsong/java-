package 网易0808;

import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            sum += t / 2;
        }
        System.out.println(sum);
    }
}
