package test3;

import java.util.Arrays;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n * 6][2];
        for (int i = 0; i < n * 6; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);

    }
}
