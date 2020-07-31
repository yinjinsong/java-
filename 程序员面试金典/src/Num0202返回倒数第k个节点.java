public class Num0202返回倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) fast = fast.next;
        while (fast!= null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
