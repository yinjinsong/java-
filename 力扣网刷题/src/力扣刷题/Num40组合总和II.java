package 力扣刷题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num40组合总和II {
    public static void main(String[] args) {
        combinationSum2(new int[]{1, 2, 2, 5}, 8);
    }
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] visited;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }

    private static void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target<0) return;
        for (int i = start; i < candidates.length; i++) {
            if(i>start&&candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
