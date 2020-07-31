import java.util.ArrayList;
import java.util.List;

public class Num113路径总和3 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if(root==null) return;
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && 0 == sum) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum );
        path.remove(path.size() - 1);
    }
}
