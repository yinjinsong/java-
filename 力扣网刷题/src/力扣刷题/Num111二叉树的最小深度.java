package 力扣刷题;

public class Num111二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if (leftHeight == 0 || rightHeight == 0) {
            return leftHeight + rightHeight + 1;
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }
}
