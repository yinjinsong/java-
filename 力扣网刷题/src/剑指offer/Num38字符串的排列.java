package 剑指offer;

import java.util.*;

public class Num38字符串的排列 {
    public static void main(String[] args) {
        String[] aabs = permutation2("aaa");
        System.out.println(Arrays.toString(aabs));
    }
    //使用set去重
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        Set<String> set = new HashSet<>();

        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, visited, new StringBuilder(), set);
        return set.toArray(new String[0]);
    }
    private void dfs(char[] arr,
                     boolean[] visited,
                     StringBuilder stringBuilder,
                     Set<String> set) {
        if (stringBuilder.length() == arr.length) {
            set.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            stringBuilder.append(arr[i]);
            visited[i] = true;
            dfs(arr, visited, stringBuilder, set);
            visited[i] = false;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    public static String[] permutation2(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        //排序方便剪枝
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        List<String> results = new ArrayList<>();
        dfs2(arr, visited, new StringBuilder(), results);
        return results.toArray(new String[0]);
    }

    /**
     *
     * @param arr 给定字符串
     * @param visited  用于标识当前字符是否被用过了
     * @param sb 用于存储一次dfs搜索的结果
     * @param results 用于存储所有搜索的结果
     */
    private static void dfs2(char[] arr,
                      boolean[] visited,
                      StringBuilder sb,
                      List<String> results) {
        if (sb.length() == arr.length) {
            results.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            //使用!visited[i-1]要快一点，避免一些不能生成结果的搜索
            if (i > 0 && !visited[i - 1] && arr[i] == arr[i - 1]) {
                continue;
            }
            sb.append(arr[i]);
            visited[i] = true;
            dfs2(arr, visited, sb, results);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
