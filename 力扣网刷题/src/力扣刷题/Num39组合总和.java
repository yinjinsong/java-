package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num39组合总和 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target,0);
        return ans;
    }

    private void dfs(int[] candidates, int target,int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target<0) return;
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
