package 剑指offer;

public class Num10II青蛙跳台阶 {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
        }
        return f[n] % 1000000007;

    }
}
