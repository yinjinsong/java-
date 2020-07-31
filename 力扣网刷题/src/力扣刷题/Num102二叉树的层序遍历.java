package 力扣刷题;

import java.util.*;

public class Num102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        //创建队列，作为BFS遍历容器
        Queue<TreeNode> queue = new LinkedList<>();
        //先添加根节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每次都需要获取当前层的size
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                //添加下一层
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
