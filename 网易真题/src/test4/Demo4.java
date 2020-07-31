package test4;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

    }

    public static void demo4(int[] arr) {
        int left = 0;
        int right = 0;
        int minVal = Integer.MAX_VALUE;
        //需要循环n次输出
        for (int i = 1; i < arr.length + 1; i++) {
            right = left + i - 1;
            while (right < arr.length) {
                //第一次指向0，第二次

            }
        }

    }
}
