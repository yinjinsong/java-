public class Num68二叉搜索树的最近公共祖先重要 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

}
