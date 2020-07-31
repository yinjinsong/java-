package test1;
//网址https://www.nowcoder.com/profile/645847812/test/32258390/800516
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            int j = scanner.nextInt();
            arr[i] = j;
        }
        for (int i = 0; i < t; i++) {
            String n = demo2(arr[i]);
            System.out.println(n);
        }
    }

    /**
     * 定义，S(n)表示n在十进制下的各位数字和。
     * 现在给定一个x,请你求出最小正整数n，满足x<=S(n).
     */

    /**
     * 求出S(n)
     * @param n
     * @return
     */
    public static int  sumBit(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static int demo1(int x) {
        int n = 1;
        while (x > sumBit(n)) {
            n++;
        }
        return n;
    }


    public static String demo2(int x) {
        if (x >= 1 && x <= 9) {
            return x + "";
        }
        //除数代表末尾有几个9
        int i = x / 9;
        //余数代表最高位是多少
        int j = x % 9;
        StringBuilder sb = new StringBuilder();
        if (j != 0) {
            sb.append(j);
        }
        for (int i1 = 0; i1 < i; i1++) {
            sb.append("9");
        }
        return sb.toString();
    }

    public static int demo3(int x) {
        if (x > 100000) {
            return -1;
        }
        if (x < 9) {
            return x;
        }
        //除数代表末尾有几个9
        int i = x / 9;
        //余数代表最高位是多少
        int j = x % 9;
        //需要返回的结果
        int n = 1;
        n *= j;
        for (int i1 = 0; i1 < i; i1++) {
            n = n * 10 + 9;
        }
        return n;

    }
}
