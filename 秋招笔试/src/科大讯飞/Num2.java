package 科大讯飞;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num2 {
    private static List<String> ans = new ArrayList<>();
    private static StringBuilder path = new StringBuilder();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        visited = new boolean[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        dfs(arr);
        int count = 0;
        for (String an : ans) {
            System.out.println(an);
            int num = Integer.parseInt(an);
            if(num%7==0) count++;
        }

        System.out.println(count);
    }

    private static void dfs(int[] arr) {
        if (path.length() == arr.length) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            path.append(arr[i]);
            dfs(arr);
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
