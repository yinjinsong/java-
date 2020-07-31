package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Num32I从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
