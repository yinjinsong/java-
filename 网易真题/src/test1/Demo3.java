package test1;

import java.util.Scanner;

/*
逆序对距离之和
输入
5
1 3 4 2 5
输出
3
说明
逆序对:
(3, 2)距离为2
(4, 2)距离为1
总和为3
 */
public class Demo3 {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] temp = new int[t];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(count);

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
        int t = 0;//指向temp数组的当前索引

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = right;
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
