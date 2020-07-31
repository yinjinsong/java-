package sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortDemo {
    public static int count = 0;
    public static int sum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] temp = new int[t];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
        System.out.println(sum);

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid, temp);

            mergeSort(arr, mid+1 , right, temp);

            merge(arr, left, mid, right, temp);
        }
    }
    /**
     *
     * @param arr 原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = left;//指向temp数组的当前索引

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
                //逆序对数量
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        for (int i1 = left; i1 <= right; i1++) {
            arr[i1] = temp[i1];
        }
    }
}
