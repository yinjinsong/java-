public class Num14剪绳子2 {
    public int cuttingRope(int n) {
        long ans = 1;
        if(n<=3) return n - 1;
        if (n % 3 == 1) {
            n -= 4;
            ans *= 4;
        } else if (n % 3 == 2) {
            n -= 2;
            ans *= 2;
        }
        while (n != 0) {
            ans = (ans * 3) % 1000000007;
            n -= 3;
        }
        return (int)ans;
    }
}
