package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num216组合总和III {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return ans;
    }

    private void dfs(int k, int n, int start) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (n < 0) return;
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
