package 力扣刷题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num47全排列II {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return ans;
    }

    private void dfs(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            //排序后遇到重复的元素就跳过
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

}

