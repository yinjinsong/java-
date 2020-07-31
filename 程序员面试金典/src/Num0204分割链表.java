public class Num0204分割链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode slow = head, fast = head;
        //fast左边一定是小于x的节点
        while (fast != null) {
            if (fast.val < x) {
                int t = fast.val;
                fast.val = slow.val;
                slow.val = t;
                slow = slow.next;
            }
            fast = fast.next;
        }
        return head;
    }
}
