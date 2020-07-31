package 力扣刷题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Num173二叉搜索树迭代器 {
    class BSTIterator2 {
        private List<Integer> list = new ArrayList<>();
        private int pos = 0;
        public BSTIterator2(TreeNode root) {
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return list.get(pos++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return pos < list.size();
        }
    }

    class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode p = stack.pop();
            int ans = p.val;
            p = p.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            return ans;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
