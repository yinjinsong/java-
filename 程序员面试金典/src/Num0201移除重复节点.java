import java.util.HashSet;

public class Num0201移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode cur = head;
        HashSet<Integer> set = new HashSet<>();
        while (cur != null && cur.next != null) {
            set.add(cur.val);
            if (set.contains(cur.next.val)) cur.next= cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}
