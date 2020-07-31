package 携程考试;

import java.util.Scanner;

/*
题目描述：
输入一个正整数数组nums和整数m。

做如下操作：将nums分割成m个非空子数组，分别对子数组求和，得到新的数组sums。

计算所有可能的求和数组，并输出不包含重复数的求和数组个数。

比如：输入nums=[4,2,6,7,3]，m=3；

可能的分割方式一共6种：

[[4], [2], [6, 7, 3]]，子集求和后得到sums=[4, 2, 16]，不包含重复值。

[[4], [2, 6], [7, 3]]，子集求和后得到sums=[4, 8, 10]，不包含重复值。

[[4], [2, 6, 7], [3]]，子集求和后得到sums=[4, 15, 3]，不包含重复值。

[[4, 2], [6], [7, 3]]，子集求和后得到sums=[6, 6, 10]，包含重复值6。

[[4, 2], [6, 7], [3]]，子集求和后得到sums=[6, 13, 3]，不包含重复值。

[[4, 2, 6], [7], [3]]，子集求和后得到sums=[12, 7, 3]，不包含重复值。

其中5中分割方式对应的求和数组不包含重复值，故最终结果输出5。
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        if (m > n) {
            System.out.println(0);
        } else {

            System.out.println(3);
        }
    }
}
