package 力扣刷题;

public class Num572另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        //分
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);
        //治
        return isSame(s, t) || left || right;
    }

    //判断两棵树是否相同
    private boolean isSame(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
