package sort;

import java.util.Date;

public class QuickSortDemo {

    public static void main(String[] args) {
       // int[] arr = {4, 3, 1, 6, 8, 3, 1, 4, 5};
        int[] arr = new int[99999999];
        for (int i = 0; i < 99999999; i++) {
            arr[i] = (int) (Math.random() * 100000000);
        }
        long start = new Date().getTime();
        System.out.println("开始排序");
        quickSort(arr, 0, arr.length - 1);
        System.out.println(new Date().getTime() - start);
        //System.out.println(Arrays.toString(arr));
    }

    /*
        0.如果left>right则直接退出循环
        1.先设置两个变量作为哨兵接收left和right
        2.哨兵r向左移动直到找到一个小于基准数的数停下。哨兵l向又移动直到找到一个大于基准书的数停下。（移动的时候需要判断l<r)
        3.交换arr[l]和arr[r]的值（需要判断了l<r)
        4.直到l=r时退出循环，此时将arr[l]和arr[begin]基准数交换，开始从l左边开始左递归，l右边开始右递归。
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (left > right) {
            return;
        }

        int l = left;
        int r = right;

        int privot = arr[left];//选取第每次分组的第一个数作为基准数

        while (l < r) {
            while (arr[r] >= privot && l < r) {
                r--;
            }
            while (arr[l] <= privot && l < r) {
                l++;
            }
            //l和r停止时，需要交换
            int t = arr[r];
            arr[r] = arr[l];
            arr[l] = t;
        }
        //退出循环，需要交换当前值和基准数，基准数归位
        arr[left] = arr[l];
        arr[l] = privot;

        //开始递归
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }

}
