package test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            for (int i1 = 0; i1 < n; i1++) {
                list.add(scanner.nextInt());
            }
        }
        Collections.sort(list);
        //排序过后只需要判断最后一个数字是否大于等于倒数第二个数字和第一个数字的和
        if (list.get(list.size() - 1) < list.get(list.size() - 2) + list.get(list.size() - 3)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }



}
