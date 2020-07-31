package 力扣刷题;

public class Num19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
