import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Num0403特定深度节点链表 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        ArrayList<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(dummy.next);
        }
        return list.toArray(new ListNode[0]);
    }
}
