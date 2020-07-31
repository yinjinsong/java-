package 剑指offer;

public class Num14II剪绳子2 {
    //最多只能有两个2，其余都是3。
    public int cuttingRope(int n) {
        if(n<=3) return n - 1;
        long ans = 1;
        if (n % 3 == 1) {
            ans *= 4;
            n -= 4;
        }
        if (n % 3 == 2) {
            ans *= 2;
            n -= 2;
        }
        while (n > 0) {
            ans *= 3;
            ans %= 1000000007;
            n -= 3;
        }
        return (int)ans;
    }
}
