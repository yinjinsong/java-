package 趋势科技考试;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(josephProblem(n));
    }
    public static int josephProblem(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int i = 0;
        int count = 0;
        while (list.size() != 1) {
            count++;
            i = (i + count) % list.size();
            Integer remove = list.remove(i);
            System.out.print(remove + " ");

        }
        return list.get(0);

    }
}
