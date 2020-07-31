package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String[] args) {

    }
    //分治
    public List<Integer> postorderTraversal(TreeNode1 root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;

        }
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        ans.addAll(left);
        ans.addAll(right);
        ans.add(root.val);


        return ans;
    }

    //递归
    public static void postorderHelper(TreeNode1 root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        postorderHelper(root.left, ans);
        postorderHelper(root.right, ans);

        ans.add(root.val);
    }
}
