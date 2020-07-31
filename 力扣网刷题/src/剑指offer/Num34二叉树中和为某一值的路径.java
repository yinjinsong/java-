package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class Num34二叉树中和为某一值的路径 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        dfs(root, new ArrayList<Integer>(), sum, results);
        return results;
    }

    /**
     *
     * @param root 传入结点
     * @param path  当前路径
     * @param remainSum 剩余值
     * @param results 结果集
     */
    private void dfs(TreeNode root,
                     ArrayList<Integer> path,
                     int remainSum,
                     List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        remainSum -= root.val;
        if (remainSum == 0 && root.left == null && root.right == null) {
            results.add(new ArrayList<>(path));
        }
        dfs(root.left, path, remainSum, results);
        dfs(root.right, path, remainSum, results);
        path.remove(path.size() - 1);
    }
}
