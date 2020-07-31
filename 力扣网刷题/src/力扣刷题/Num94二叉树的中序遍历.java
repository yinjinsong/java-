package 力扣刷题;

import java.util.*;

public class Num94二叉树的中序遍历 {
    private List<Integer> ans = new ArrayList<>();
    //递归遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    //迭代遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }

}
