package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), results);
        return results;

    }

    private void dfs(int[] nums,
                     boolean[] visited,
                     ArrayList<Integer> path,
                     List<List<Integer>> results) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, path, results);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute2(int[] nums) {
        visited = new boolean[nums.length];
        dfs2(nums, 0);
        return ans;
    }

    private void dfs2(int[] nums, int start) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            dfs2(nums, start + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

}
