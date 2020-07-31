public class Num343整数拆分 {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int ans = 1;
        if (n % 3 == 1) {
            n -= 4;
            ans *= 4;
        } else if (n % 3 == 2) {
            n -= 2;
            ans *= 2;
        }
        return ans * (int) Math.pow(3, n / 3);
    }
}
