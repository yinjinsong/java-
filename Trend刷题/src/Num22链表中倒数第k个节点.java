public class Num22链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head, cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if(k<=0||k>len) return null;
        for (int i = 0; i < k; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}


