package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long low, long high) {
        if (root==null) return true;
        if(root.val<=low||root.val>=high) return false;
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
    }

    private List<Integer> list = new ArrayList<>();
    public boolean isValidBST2(TreeNode root) {
        dfs2(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root.left);
        list.add(root.val);
        dfs2(root.right);
    }
}
