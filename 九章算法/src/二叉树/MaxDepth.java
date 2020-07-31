package 二叉树;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.left.left = new TreeNode1(4);
        root.left.left.left = new TreeNode1(10);
        root.left.right = new TreeNode1(5);
        root.right = new TreeNode1(3);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(7);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode1 root) {
        //分治
        int depth = 0;
        if (root == null) {
            return depth;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }



}
