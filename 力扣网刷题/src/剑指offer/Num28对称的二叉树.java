package 剑指offer;

public class Num28对称的二叉树 {
    //对称的定义
    /*
        L.val=R.val
        L.left=R.right
        L.right=R.left
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return helper(left.right, right.left) && helper(left.left, right.right);
    }

}
