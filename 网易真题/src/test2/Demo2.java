package test2;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int j = scanner.nextInt();
            int[] arr = new int[j];
            for (int i1 = 0; i1 < j; i1++) {
                arr[i1] = scanner.nextInt();
            }
            System.out.println(demo2(arr));
        }
    }

    public static int demo2(int[] arr) {
        int pre = 0;
        int curCount = 1;
        int maxCount = 1;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= sum) {
                curCount++;
                sum += arr[i];
                maxCount = Math.max(curCount, maxCount);
            } else {
                curCount = 1;
                pre = i;
                sum = arr[i];
            }
        }
        return maxCount;
    }

}
