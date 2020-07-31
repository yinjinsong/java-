package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode1 root) {
        //分治
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        ans.addAll(left);
        ans.add(root.val);
        ans.addAll(right);

        return ans;
    }
    //递归
    public static void inorderHelper(TreeNode1 root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, ans);
        ans.add(root.val);
        inorderHelper(root.right, ans);
    }

    //非递归
}
