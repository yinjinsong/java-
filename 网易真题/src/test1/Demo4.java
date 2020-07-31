package test1;

import java.util.Scanner;

/*
2
5
1 3 9 2 6
5
4 2 9 16 7
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int j = scanner.nextInt();
            int[] arr = new int[j];
            for (int i1 = 0; i1 < j; i1++) {
                arr[i1] = scanner.nextInt();
            }
            System.out.println(demo4(arr));
        }


    }
    //2 3 5 9 18
    public static int demo4(int[] arr) {
        //两个辅助指针，标记从哪里开始
        int left = 0;
        int right = 1;
        //最大子序列长度
        int maxCount = 1;
        //当前子序列长度
        int curCount = 1;
        int sum = arr[0];
        //当右边指针未达到数组最右边边界时
        while (right < arr.length) {
            //如果满足条件
            if (arr[right] >= sum) {
                //将当前值加入总和
                sum += arr[right];
                //当前子序列的长度
                curCount = right - left + 1;
                //right指针向后移动一位
                right++;
                //更新最大长度
                maxCount = maxCount > curCount ? maxCount : curCount;
            } else {
                //如果不满足条件，则需要从sum中减去left所在位置的值
                sum -= arr[left];
                //将left向后移动一位
                left++;
            }
        }
        return maxCount;
    }


}
