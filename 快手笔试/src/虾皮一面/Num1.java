package 虾皮一面;

import java.util.Arrays;

public class Num1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{3, 4, 5, 1, 2,6})));
    }

    public static int[] sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            while (arr[i] != i + 1) {
                int t = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = t;
            }
            i++;
        }
        return arr;
    }
}
