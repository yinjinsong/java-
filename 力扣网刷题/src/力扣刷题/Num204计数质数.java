package 力扣刷题;

public class Num204计数质数 {
    public static void main(String[] args) {
        System.out.println(countPrimes2(30));
    }
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrim(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes2(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isPrim = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            //质数的倍数都不是质数
            if (!isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrim[i]) {
                count++;
            }
        }
        return count;
    }

}
