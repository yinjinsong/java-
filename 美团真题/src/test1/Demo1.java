package test1;

import java.math.BigInteger;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        StringBuilder sb1 = new StringBuilder(s1);
        sb1.deleteCharAt(0);
        sb1.deleteCharAt(sb1.length() - 1);
        BigInteger num1 = new BigInteger(sb1.toString());

        String s2 = scanner.next();
        StringBuilder sb2 = new StringBuilder(s2);
        sb2.deleteCharAt(0);
        sb2.deleteCharAt(sb2.length() - 1);
        BigInteger num2 = new BigInteger(sb2.toString());

        BigInteger sum = num1.add(num2);
        System.out.println("\"" + sum + "\"");

    }
}
