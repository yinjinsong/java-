package 力扣刷题;

import java.util.Stack;

public class Num101对称二叉树 {
    //递归
    public boolean isSymmetric(TreeNode root) {
       if(root==null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if(left==null||right==null) return left == null && right == null;
        //对称条件1.左子树结点和右子树结点相等2.左子树的左子树和右子树的右子树对称3.左子树的右子树和右子树的左子树对称
        return left.val == right.val && dfs(left.right, right.left) && dfs(left.left, right.right);
    }


    //迭代
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode l = root.left, r = root.right;
        while (l != null || r != null || !left.isEmpty() || !right.isEmpty()) {
            while (l != null && r != null) {
                left.push(l);
                l = l.left;
                right.push(r);
                r = r.right;
            }
            if (l != null || r != null) return false;
            l = left.pop();
            r = right.pop();
            if(l.val!=r.val) return false;
            l = l.right;
            r = r.left;
        }
        return true;

    }




}
