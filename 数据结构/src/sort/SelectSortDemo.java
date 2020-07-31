package sort;

import java.util.Arrays;

public class SelectSortDemo {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 4, 5};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        1.选择排序的趟数是arr.length-1次，每一次排序假定当前位置是最小值
        2.往后查找数组中是否有比当前值还要小的数，如果有则记录下最小值位置
        3.交换最小值和第一个起始的位置
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minVal = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    //记录最小位置的值和下标
                    minIndex = j;
                    minVal = arr[j];
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minVal;
            }
            System.out.printf("第%d趟后的数组", i + 1);
            System.out.println(Arrays.toString(arr));
        }
    }
}
