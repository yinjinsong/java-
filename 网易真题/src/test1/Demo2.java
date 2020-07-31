package test1;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[][] arr = new long[t][4];
        for (int i = 0; i < t; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                Long j = scanner.nextLong();
                arr[i][i1] = j;
            }
        }
        for (int i = 0; i < t; i++) {
            long A = arr[i][0];
            long B = arr[i][1];
            long p = arr[i][2];
            long q = arr[i][3];
            long count = demo(A, B, p, q);
            System.out.println(count);
        }

    }

    public static int demo(long A, long B, long p, long q) {
        int num = 0;
        while (B > A) {
            if (B - A <= p) {
                A = A + p;
                num++;
            } else {
                p = p * q;
                num++;
            }
        }
        return num;
    }
}
