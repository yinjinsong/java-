package test4;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        long b = scanner.nextLong();
        //将这里返回的ans与b求最大公约数即可
        long ans = demo2(a, b);
        if (ans == 0) {
            System.out.println(b);
            return;
        }
        long tmp = 0;
        System.out.println(gcd(ans, b));
    }

    //将第一个很大的数long类型装不下，需要按位处理，
    public static long demo2(String a, long b) {
        //余数
        long remainder = 0;
        //从最高位开始取一位与被除数
        for (int i = 0; i < a.length(); i++) {
            remainder = remainder * 10 + a.charAt(i) - '0';
            remainder %= b;
        }
        return remainder;
    }

    //求最大公约数
    public static long gcd(long minNum, long maxNum) {
        //确保第一个数小于第二个数
        if (minNum > maxNum) {
            long remp = minNum;
            minNum = maxNum;
            maxNum = minNum;
        }
        long remainder = 1;
        //用于保存结果
        long result = 0;
        while (remainder != 0) {
            result = minNum;
            remainder = maxNum % minNum;
            maxNum = minNum;
            minNum = remainder;
        }
        return result;
    }
}






