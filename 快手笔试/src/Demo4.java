import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (map[i - 1][j] == 0 && map[i + 1][j] == 0 && map[i][j - 1] == 0 && map[i][j + 1] == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
