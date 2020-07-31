import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s;
        for (int i = 0; i < n; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            s = scanner.next();
            long result = 1;
            if (s.equals("+")) {
                result = (num1 + num2) % 1000000007;
            } else if (s.equals("-")) {
                result = (num1 - num2) % 1000000007;
            } else if (s.equals("*")) {
                result = (num1 * num2) % 1000000007;
            } else if (s.equals("^")) {
                while (num2 > 0) {
                    if (num2 % 2 == 1) {
                        result = (result * num1) % 1000000007;
                    }
                    num1 =(num1*num1)%1000000007;
                    num2 >>= 1;
                }
            }
            System.out.println(result);
        }
    }
}
