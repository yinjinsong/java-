import java.util.HashSet;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0 ;j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        //存放获奖学生下标
        HashSet<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int maxScore = 0;
            for (int j = 0; j < n; j++) {
                int score = arr[j][i];
                if (score >= maxScore) {
                    maxScore = score;
                }
            }
            for (int k = 0; k < n; k++) {
                if (arr[k][i] == maxScore) {
                    indexSet.add(k);
                }
            }
        }

        System.out.println(indexSet.size());

    }
}
