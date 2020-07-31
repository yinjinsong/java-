public class Num16数值的整数次方 {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        double ans = 1;
        long exp = n;
        if (exp < 0) {
            x = 1 / x;
            exp *= -1;
        }
        while (exp != 0) {
            if (exp % 2 == 1) {
                ans *= x;
                exp--;
            } else {
                x *= x;
                exp /= 2;
            }
        }
        return ans;
    }
}
