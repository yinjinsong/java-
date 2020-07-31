package 力扣刷题;

public class Num100相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null & q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //判断当前根节点的值是否相等
        if (p.val != q.val) {
            return false;
        }
        //继续比较左子树是否相等以及右子树是否相等
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
