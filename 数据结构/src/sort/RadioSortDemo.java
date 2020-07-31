package sort;

import java.util.Arrays;

public class RadioSortDemo {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 6, 8, 3, 1, 4, 5};
        radionSort(arr);

    }

    /*
        1.找出数组中最大的数，他的位数就是要循环的次数
        2.新建10个桶，并新建记录10个桶有效个数的数组
        3.根据个位、十位、百位依次将数组中的数按顺序放入桶中
     */
    public static void radionSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = String.valueOf(max).length();

        int[][] bucket = new int[10][arr.length];//桶
        int[] bucketEleCount = new int[10]; //记录桶的有效数据个数

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {
                int tmp = arr[j] / n % 10;//计算出当前位数
                bucket[tmp][bucketEleCount[tmp]++] = arr[j];
            }

            //将桶中的有效数据依次取出到数组中
            int index = 0;
            for (int k = 0; k < bucketEleCount.length; k++) {
                if (bucketEleCount[k] > 0) {
                    for (int l = 0; l < bucketEleCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketEleCount[k] = 0;
            }
            System.out.println("第" + (i + 1) + "排序后的数组");
            System.out.println(Arrays.toString(arr));

        }
    }
}
