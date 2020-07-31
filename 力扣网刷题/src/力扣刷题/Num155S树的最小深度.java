package 力扣刷题;

import java.util.LinkedList;
import java.util.Queue;

public class Num155S树的最小深度 {
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //分
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //这里需要判断，因为要保证到叶子结点
        //如果左子树为空
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

    //采用BFS，
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;


            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

        }
        return 0;
    }

}
