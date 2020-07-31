package 力扣刷题;

public class Num92反转链表II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < m - 1; i++) slow = slow.next;
        for (int i = 0; i < n + 1; i++) fast = fast.next;
        ListNode pre = slow.next, cur = pre.next;
        while (cur != fast) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next.next = fast;
        slow.next = pre;
        return dummy.next;
    }
}
