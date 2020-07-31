package 力扣刷题;


public class Num83删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
//        ListNode cur = head;
//        while (cur != null) {
//            if (cur.next!=null&&cur.next.val==cur.val)
//                cur.next = cur.next.next;
//            else cur = cur.next;
//        }
//        return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            while (fast != null && fast.val == slow.val)
                fast = fast.next;
            slow.next = fast;
            slow = fast;
        }
        return head;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}