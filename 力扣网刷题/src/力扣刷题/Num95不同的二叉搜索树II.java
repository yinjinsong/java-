package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num95不同的二叉搜索树II {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int l, int r) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (l > r) {
            ans.add(null);
            return ans;
        }
        //枚举根节点的位置
        for (int i = l; i <= r; i++) {
            //根节点左边比他小的元素才能作为左子树
            List<TreeNode> left = dfs(l, i - 1);
            //根节点右边比他大的元素才能作为右子树
            List<TreeNode> right = dfs(i + 1, r);
            //左子树的方案*右子树的方案就是最后的总方案
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
