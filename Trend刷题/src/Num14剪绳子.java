public class Num14剪绳子 {
    public int cuttingRope(int n) {
        if(n<=3) return n - 1;
        int ans = 1;
        if (n % 3 == 1) {
            ans *= 4;
            n -= 4;
        } else if (n % 3 == 2) {
            ans *= 2;
            n -= 2;
        }
        ans *= Math.pow(3, n / 3);
        return ans;
    }
}
