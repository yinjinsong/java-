import java.util.ArrayList;
import java.util.List;

public class Num34二叉树中和为某一值的路径重要 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if(root==null) return;
        if (sum == root.val && root.left == null && root.right == null) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
