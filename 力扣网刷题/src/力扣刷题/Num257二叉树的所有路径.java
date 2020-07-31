package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num257二叉树的所有路径 {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder path) {
        if (root == null) {
            return;
        }
        //root不为空需要添加该结点进路径
        if (path.length() != 0) {
            path.append("->");
        }
        path.append(root.val);

        //如果是叶子结点则返回答案
        if (root.left == null && root.right == null) {
            ans.add(path.toString());
            return;
        }
        int len = path.length();
        dfs(root.left, path);
        //撤销选择
        path.delete(len, path.length());
        dfs(root.right, path);
    }
}
