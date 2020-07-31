package 力扣刷题;

public class Num236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归结束条件，root为null或者root为p,q结点
        if (root == null || root == p || root == q) {
            return root;
        }
        //分
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果在root左子树和右子树中都找到了，那么root就是lca
        if (left != null && right != null) {
            return root;
        }
        //如果只在root的左子树找到了，向上返回left
        else if (left != null) {
            return left;
        }
        //如果指在root的右子树中找到了，向上返回right
        else {
            return right;
        }

    }
}
