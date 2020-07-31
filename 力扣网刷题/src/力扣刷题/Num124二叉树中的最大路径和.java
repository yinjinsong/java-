package 力扣刷题;

/*
思路：
有4种情况要考虑
left + root
right + root
root
left + right + root
不断往上传递的值 只可能是 1， 2， 3中的一种
第四种情况只可能保存在 max里面 而不可能在 curr_max
*/

public class Num124二叉树中的最大路径和 {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + root.val);
        //如果左子树或者右子树的路径和小于0则不选择该路径。即路径和为0
        return Math.max(0, Math.max(left, right) + root.val);
    }


}
