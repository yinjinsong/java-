package 网易0808;

import java.util.Scanner;

public class Num3 {
    static int ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            ans = Integer.MAX_VALUE;
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();
            dfs(arr, 0, 0, 0, 0);
            System.out.println(ans);
        }
    }

    private static void dfs(int[] arr, int index, int sumA, int sumB, int sumDrop) {
        if (index == arr.length) {
            if (sumA == sumB) {
                ans = Math.min(sumDrop, ans);
            }
            return;
        }
        dfs(arr, index + 1, sumA + arr[index], sumB, sumDrop);
        dfs(arr, index + 1, sumA, sumB + arr[index], sumDrop);
        dfs(arr, index + 1, sumA, sumB, sumDrop + arr[index]);
    }
}
