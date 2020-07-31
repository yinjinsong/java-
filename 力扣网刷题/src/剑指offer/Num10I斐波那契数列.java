package 剑指offer;

public class Num10I斐波那契数列 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
        }
        return f[n] % 1000000007;
    }
}
