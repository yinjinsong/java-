import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num37序列化二叉树重要 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root);
    }

    private String dfs(TreeNode root) {
        if(root==null) return "#";
        String ans = "";
        ans += root.val + "," + dfs(root.left) + "," + dfs(root.right);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return dfs2(list);
    }

    private TreeNode dfs2(List<String> list) {
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = dfs2(list);
        root.right = dfs2(list);
        return root;

    }
}
