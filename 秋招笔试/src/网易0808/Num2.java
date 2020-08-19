package 网易0808;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 第一行输入两个正整数n和m
 * 第二行输入m个数，表示序列
 * 5 3
 * 2 1 5
 * 输出
 * 2 1 3 4 5
 */
public class Num2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
            set.add(arr[i]);
        }
        int[] need = new int[n - m];
        int index = 1;
        for (int i = 0; i < need.length; i++) {
            while (set.contains(index)) index++;
            need[i] = index++;
        }
        int i = 0, j = 0;
        index = 0;
        int[] ans = new int[n];
        while (i < arr.length && j < need.length) {
            if (arr[i] < need[j]) ans[index++] = arr[i++];
            else ans[index++] = need[j++];
        }
        while (i < arr.length) ans[index++] = arr[i++];
        while (j < need.length) ans[index++] = need[j++];
        for (int an : ans) System.out.print(an + " ");
    }
}
