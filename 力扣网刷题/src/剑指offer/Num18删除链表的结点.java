package 剑指offer;

public class Num18删除链表的结点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode dummy = preHead;

        while (dummy.next != null) {
            if (dummy.next.val == val) {
                ListNode next = dummy.next.next;
                dummy.next = next;
                break;
            }
            dummy = dummy.next;
        }
        return preHead.next;
    }
}
