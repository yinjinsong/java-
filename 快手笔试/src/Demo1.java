import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] grade = new int[N];
        for (int i = 0; i < N; i++) {
            grade[i] = scanner.nextInt();
        }
        //把上一行的回车符给读取掉
        //scanner.nextLine();
//        String[][] strings = new String[M][3];
////        for (int i = 0; i < M; i++) {
////            strings[i][0] = scanner.next();
////            strings[i][1] = scanner.next();
////            strings[i][2] = scanner.next();
////        }
        //重要
        scanner.nextLine();
        String[] strings = new String[M];
        for (int i = 0; i < M; i++) {
            strings[i] = scanner.nextLine();
        }
        for (int i : grade) {
            System.out.println(i);
        }
        for (int i = 0; i < M; i++) {
            String[] split = strings[i].split(" ");
            for (String s : split) {
                System.out.print(s + " ");
            }
        }

    }
}
