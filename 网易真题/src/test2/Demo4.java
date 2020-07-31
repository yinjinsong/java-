package test2;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long t = scanner.nextLong();
        for (int i = 0; i < t; i++) {
            Integer n = scanner.nextInt();
            Long m = scanner.nextLong();
            long[] arr = new long[n];
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1] = scanner.nextLong();
            }
            System.out.println(demo4(m, arr));
        }
    }


    /**
     *
     *
     * @param m m代表书包中初始积木输血量
     * @param arr 代表n堆的积木数量
     * @return
     */
    public static String demo4(long m, long[] arr) {

        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            //当前积木堆的最苛刻解数量总和即 0、1、2、3、4、5...
            sum1= (i * (i + 1)) / 2;
            //当前堆中的积木数量总和
            sum2 += arr[i];
            if (sum2 + m < sum1) {
                return "NO";
            }
        }
        return "YES";
    }
}
