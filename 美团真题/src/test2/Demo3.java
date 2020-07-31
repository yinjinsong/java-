package test2;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        //MPMPCPMCMDEFEGDEHINHKLIN
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        ArrayList<Integer> list = new ArrayList<>();
        //记录当前段的最大下标
        int maxIndex = 0;

        int preIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndex = s.lastIndexOf(c);
            maxIndex = Math.max(lastIndex, maxIndex);
            if (maxIndex == i) {
                list.add(maxIndex - preIndex + 1);
                preIndex = maxIndex + 1;
            }
        }
        for (Integer integer : list) {
            System.out.println(integer + " ");
        }
    }
}
