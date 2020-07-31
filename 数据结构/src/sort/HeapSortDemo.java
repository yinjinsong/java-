package sort;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9, 10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr) {
        int temp = 0;
        //1.调整数组至大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            //2.交换堆顶元素和最后一个元素
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //3.把数组重建大顶堆
            adjustHeap(arr, 0, j);
        }
    }
    /**
     *
     * @param arr 待调整数组
     * @param i   非叶子结点在数组中的索引
     * @param length 有多少个元素，逐渐减小
     */
    public static void adjustHeap(int[] arr, int i, int length) {
//        //记录当前结点值
//        int temp = arr[i];
//        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
//
//            //选出左右子结点中最大的一个，并记录位置
//            if (k + 1 < length && arr[k] < arr[k + 1]) {
//                k++;
//            }
//            //如果子结点的值大于父结点则交换，并将i指向k
//            if (arr[k] > temp) {
//                arr[i] = arr[k];
//                i = k;
//            } else {
//                break;
//            }
//        }
//        arr[i] = temp;
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {

            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
