package 剑指offer;

public class Num64求1到n的和 {
    public static void main(String[] args) {
        System.out.println(sumNums(5));
    }
    public static int sumNums(int n) {
        boolean b = n > 1 && (n +=sumNums(n - 1)) > 0;
        return n;
    }

    private static int ans = 0;
    public static int sumNums2(int n) {
        boolean b = n > 1 && (sumNums2(n - 1)) > 0;
        ans += n;
        return ans;
    }
}
