package 力扣刷题;

public class Num50实现Pow函数 {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long newN = n;
        double ans = 1;
        if (newN < 0) {
            x = 1 / x;
            newN *= -1;
        }

        while (newN > 0) {
            if (newN % 2 == 1) {
                ans *= x;
            }
            x *= x;
            newN >>= 1;

        }
        return ans;
    }
}
