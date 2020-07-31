package 二叉树;

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public TreeNode1 lowestCommonAncestor(TreeNode1 root, TreeNode1 A, TreeNode1 B) {
        if (root == null || root == A || root == B) {
            return root;
        }

        //分
        TreeNode1 left = lowestCommonAncestor(root.left, A, B);
        TreeNode1 right = lowestCommonAncestor(root.right, A, B);

        //治
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
