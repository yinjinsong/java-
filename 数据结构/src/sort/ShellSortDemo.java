package sort;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSortDemo {
    public static void main(String[] args) {
//        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = new int[99999999];
        for (int i = 0; i < 99999999; i++) {
            arr[i] = (int) (Math.random() * 100000000);
        }
        long start = new Date().getTime();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(date));
        shellSort(arr);
        long end = new Date().getTime();
        Date date1 = new Date();
        System.out.println(sdf.format(date1));
        System.out.println("用时" + (end - start) + "毫秒");
        //System.out.println(Arrays.toString(arr));
    }

    /*
        1.先分组，分组之后采用插入排序
     */
    public static void shellSort(int[] arr) {

        int insertValue=0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;
                insertValue = arr[insertIndex];

                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
    }
}

