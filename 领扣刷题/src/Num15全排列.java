import java.util.ArrayList;
import java.util.List;

public class Num15全排列 {
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
                     ArrayList<Integer> permutation,
                     List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
