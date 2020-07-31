package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num77组和 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, new ArrayList<>());
        return ans;
    }

    private void dfs(int n, int k, int start, ArrayList<Integer> path) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = start; i <= n; i++) {
            //选择
            path.add(i);
            //递归
            dfs(n, k, i + 1, path);
            //复原（回溯）
            path.remove(path.size() - 1);
        }
    }
}
