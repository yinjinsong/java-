import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Num337打家劫舍3 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    list.add(0);
                    continue;
                }
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                else queue.offer(null);
                if (node.right != null) queue.offer(node.right);
                else queue.offer(null);
            }
        }
        int[] dp = new int[list.size() + 1];
        dp[0] = 0;
        dp[1] = list.get(0);
        dp[2] = Math.max(dp[1], list.get(1));
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 3] + Math.max(list.get(i - 1), list.get(i - 2)));
        }
        return dp[dp.length - 1];
    }
}
