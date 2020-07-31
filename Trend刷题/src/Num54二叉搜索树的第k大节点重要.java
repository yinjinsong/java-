public class Num54二叉搜索树的第k大节点重要 {
    int ans = 0, k = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        k--;
        if (k == 0) {
            ans = root.val;
            return;
        }
        dfs(root.left);
    }
}
