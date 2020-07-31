package test4;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            if (num1 == 1) {
                list.add(num2);
            }
            if (num1 == 2) {
                System.out.println(demo3(list, num2));
            }
        }
    }


    public static String demo3(ArrayList<Integer> list, int target) {
        int temp = 0;
        for (int i = 0; i < list.size() && temp != target; i++) {
            //如果当前数按位或目标值等于目标值的话，则当前数可用
            //即不影响目标值为0的位数，目标值为0的为，当前值对应位也必须为0
            if ((list.get(i) | target) == target) {
                temp |= list.get(i);
            }
            //如有和target相等的数则直接退出，提升时间效率
            if (list.get(i) == target) {
                temp = target;
                break;
            }
            if (temp == target) {
                break;
            }
        }
        //循环结束后判断temp是否等于target
        if (temp == target) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
