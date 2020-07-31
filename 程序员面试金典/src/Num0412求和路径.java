public class Num0412求和路径 {
    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) ans++;
        dfs(root.left, sum);
        dfs(root.right, sum);
        sum += root.val;
    }


}
