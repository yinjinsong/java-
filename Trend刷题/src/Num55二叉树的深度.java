public class Num55二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftChildHeight = maxDepth(root.left);
        int rightChildHeight = maxDepth(root.right);
        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }
}
