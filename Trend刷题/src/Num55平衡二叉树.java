public class Num55平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
