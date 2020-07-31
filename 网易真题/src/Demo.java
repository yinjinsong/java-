import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(scanner.nextLong());
        }
        for (int i = 1; i < list1.size(); i++) {
            list2.add(list1.get(i) - list1.get(i - 1));
        }
        Collections.sort(list2);
        if (list2.get(0) <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(gcd(list2.get(0), list2.get(list2.size() - 1)));
        }
    }

    /**
     * 求两个数的最大公约数
     * @param minNum
     * @param maxNum
     * @return
     */
    public static long gcd(long minNum, long maxNum) {
        if (minNum > maxNum) {
            long temp = minNum;
            minNum = maxNum;
            maxNum = temp;
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
