import java.util.ArrayList;
import java.util.List;

public class Num95不同的二叉搜索树2 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int l, int r) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (l > r) {
            ans.add(null);
            return ans;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = dfs(l, i - 1);
            List<TreeNode> right = dfs(i + 1, r);
            for (TreeNode treeNode : left) {
                for (TreeNode node : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = treeNode;
                    root.right = node;
                    ans.add(root);
                }
            }
        }
        for (TreeNode node : ans) {
            dfs2(node);
            System.out.println();
        }
        return ans;
    }

    private void dfs2(TreeNode node) {
        if (node == null) {
            System.out.println("null ");
            return;
        }
        System.out.print(node.val+" ");
        dfs2(node.left);
        dfs2(node.right);
    }


}
