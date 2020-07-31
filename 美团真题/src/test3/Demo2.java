package test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Interval> list = new ArrayList<Interval>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(new Interval(scanner.nextInt(), scanner.nextInt()));
        }
        //先按第一个数排序
        list.sort((o1, o2) -> o1.start - o2.start);
        Interval last = list.get(0);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start < last.end) {
                count++;
            }
        }
        System.out.println(count+1);
    }
}

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
