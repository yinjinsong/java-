package 剑指offer;

public class Num27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //分
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        //z治
        root.left = right;
        root.right = left;
        return root;
    }


}
