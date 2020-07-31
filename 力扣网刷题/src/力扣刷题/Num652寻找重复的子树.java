package 力扣刷题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num652寻找重复的子树 {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) return "#";
        String path = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        map.put(path, map.getOrDefault(path, 0) + 1);
        if (map.get(path) == 2) ans.add(root);
        return path;
    }
}
