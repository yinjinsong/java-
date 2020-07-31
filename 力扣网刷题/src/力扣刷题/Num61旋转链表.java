package 力扣刷题;

public class Num61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) n++;
        k %= n;
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

}
