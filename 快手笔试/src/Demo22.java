import java.util.ArrayList;
import java.util.Scanner;

public class Demo22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            int[][] A = new int[count][2];
            int[][] B = new int[count][2];
            for (int j = 0; j < count; j++) {
                A[j][0] = scanner.nextInt();
                A[j][1] = scanner.nextInt();
            }
            for (int j = 0; j < count; j++) {
                B[j][0] = scanner.nextInt();
                B[j][1] = scanner.nextInt();
            }
            double minDistance = Integer.MAX_VALUE;
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    double xdis = (A[j][0] - B[k][0]) * (A[j][0] - B[k][0]);
                    double ydis = (A[j][1] - B[k][1]) * (A[j][1] - B[k][1]);
                    double dis = Math.sqrt(xdis + ydis);
                    minDistance = dis < minDistance ? dis : minDistance;
                }
            }
            list.add(minDistance);
        }
        for (Double aDouble : list) {
            System.out.printf("%.3f\n", aDouble);
           // System.out.println(String.format("%.3f", aDouble));
        }
    }
}
