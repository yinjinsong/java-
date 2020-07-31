package test4;

import java.util.Scanner;

public class Demo2_1 {
    public static void main(String[] args) {
        //辗转相除法
        Scanner scanner = new Scanner(System.in);
        int minNum = scanner.nextInt();
        int maxNum = scanner.nextInt();
        //求num1和num2的最大公约数
        System.out.println("最大公约数是：" + gcd(minNum, maxNum));

    }

    public static int gcd(int minNum, int maxNum) {
        //确保第一个数小于第二个数
        if (minNum > maxNum) {
            int remp = minNum;
            minNum = maxNum;
            maxNum = minNum;
        }
        int remainder = 1;
        //用于保存结果
        int result = 0;
        while (remainder != 0) {
            result = minNum;
            remainder = maxNum % minNum;
            maxNum = minNum;
            minNum = remainder;
        }
        return result;
    }

}
