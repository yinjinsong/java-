package sort;

import java.util.Arrays;

public class InsertSortDemo {

    public static void main(String[] args) {
        int[] arr = {8,3, 1, 6, 4, 5};
        System.out.println(Arrays.toString(arr));
        insetrSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        1.从数组第2位数开始比较，如果第2位数小于第1位数，则将第1位数往后移动一位。
          带插入的下标减1，变成0.不满足下标大于0退出循环，在将数组的第2位数赋值给arr[insertIndex+1]
     */
    public static void insetrSort(int[] arr) {
        int insertIndex = 0;
        int insertValue = 0;

        for (int i = 1; i < arr.length; i++) {
            insertIndex = i-1;
            insertValue = arr[i];

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }

            System.out.printf("第%d趟排序后的数组", i );
            System.out.println(Arrays.toString(arr));
        }
    }
}
