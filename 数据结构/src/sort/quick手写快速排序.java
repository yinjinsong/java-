package sort;

import java.util.Arrays;

public class quick手写快速排序 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 6, 8, 8, 5, 9, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = 0;
        int base = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //i和j相遇,交换base和arr[i]的值
        arr[left] = arr[i];
        arr[i] = base;
        //递归向左
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);


    }
}
