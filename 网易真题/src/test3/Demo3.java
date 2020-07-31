package test3;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //成绩作为下标，对应分数人数作为值
        int[] grade = new int[151];
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            //比如录入的是100分，则grade[100]++
            grade[arr[i]]++;
        }
        //询问次数
        int queryNum = scanner.nextInt();
        for (int i = 0; i < queryNum; i++) {
            //对应数组下标
            int index = scanner.nextInt()-1;
            //对应目标分数
            int target = arr[index];
            System.out.printf("%.6f\n", findLow(grade, target, arr.length));
        }

    }

    /**
     *
     * @param grade 代表每个成绩有几个人
     * @param target    需要查找的分数
     * @param num   总共人数
     * @return
     */
    public static Double findLow(int[] grade, int target, int num) {
        double count = 0;
        for (int i = 0; i <= target; i++) {
            count += grade[i];
        }
        return (count - 1) / num * 100;

    }
}


