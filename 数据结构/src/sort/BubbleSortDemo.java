package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSortDemo {
    public static void main(String[] args) {
//        int[] arr = {10, 9, 11, 12, 13};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 100000);//产生[0-100000]的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String start = simpleDateFormat.format(date1);
        System.out.println(start);
        bubbleSort(arr);

        Date date2 = new Date();
        String end = simpleDateFormat.format(date2);
        System.out.println(end);

    }

    /*
           1.冒泡排序是相邻元素比大小，如果前面元素大于后面元素则交换两个元素的位置。
           2.每一趟排序过后就会产生一个最大的数冒泡的数组最后面
           3.每经过一趟排序之后，下一趟比较的次数就会减少一次
           4.优化的冒泡排序需要判断当前趟中是否至少发生过一次交换，如果没有则代表当前数组已经有序，
           中断趟数循环。
        */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
//            System.out.printf("第%d趟排序后的数组", i + 1);
//            System.out.println(Arrays.toString(arr));

        }
    }
}
