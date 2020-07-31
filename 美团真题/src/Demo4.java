import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int mid = (n + 1) / 2;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                index = i;
                break;
            }
        }
        if (index< mid) {
            System.out.println(n + 1 - 2 * index);
        } else if (k == mid) {
            System.out.println(0);
        } else {
            System.out.println(2 * index - n - 1);
            System.out.println(2);
        }
    }

}
