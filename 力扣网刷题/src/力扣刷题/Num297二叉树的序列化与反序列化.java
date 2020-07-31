package 力扣刷题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num297二叉树的序列化与反序列化 {
    public class Codec {
        //先序遍历序列化二叉树（记录下null结点为#)
        public String serialize(TreeNode root) {
            StringBuilder ans = new StringBuilder();
            dfs(root, ans);
            return ans.toString();
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }


        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(arr));
            return dfs2(list);
        }

        private TreeNode dfs2(List<String> list) {
            if ("#".equals(list.get(0))) {
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

}
