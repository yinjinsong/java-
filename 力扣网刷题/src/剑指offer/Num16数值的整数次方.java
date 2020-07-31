package 剑指offer;

public class Num16数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(myPow(2.1, 3));
    }
    //快速幂
    public static double myPow(double x, int n) {
        //2^10=2^(1010)
        if (x == 0) {
            return 0;
        }
        long  exp = n;
        double sum = 1.0;
        if (exp < 0) {
            x = 1 / x;
            exp *= -1;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                sum *= x;
            }
            x *= x;
            exp >>= 1;
        }
        return sum;
    }
}
