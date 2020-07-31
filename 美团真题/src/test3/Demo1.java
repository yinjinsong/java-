package test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Line>> Linelists = new ArrayList<>(n);
        for (int i = 0; i < n ; i++) {
            ArrayList<Line> lines = new ArrayList<>();
            int[] arr = new int[12];
            for (int j = 0; j < 12; j++) {
                arr[j] = scanner.nextInt();
            }
            for (int j = 0; j <= 10; j += 2) {
                Line line = new Line(arr[j], arr[j + 1]);
                lines.add(line);
            }
            Linelists.add(lines);
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Line> lines = Linelists.get(i);
            Collections.sort(lines, new Comparator<Line>() {
                @Override
                public int compare(Line o1, Line o2) {
                    if (o1.ponit1 == o2.ponit1) {
                        return o1.point2 - o2.point2;
                    } else {
                        return o1.ponit1 - o2.ponit1;
                    }
                }
            });
            if (lines.get(0) == lines.get(1) &&
                    lines.get(2) == lines.get(3) &&
                    lines.get(4) == lines.get(5) &&
                    lines.get(0).ponit1 == lines.get(2).ponit1 &&
                    lines.get(0).point2 == lines.get(4).ponit1 &&
                    lines.get(2).point2 == lines.get(4).point2) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }




    }
}

class Line {
    public int ponit1;
    public int point2;

    public Line(int ponit1, int ppint2) {
        this.ponit1 = ponit1;
        this.point2 = point2;
    }
}