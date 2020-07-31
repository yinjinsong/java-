import java.util.Arrays;
import java.util.Scanner;

public class Demo3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int row = (k - 1) / n;
        int col =(k - 1)  % n;

        System.out.println("(" + arr[row] + "," + arr[col] + ")");
    }
}

