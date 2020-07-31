package 力扣刷题;





public class Num82删除链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //头结点可能会改变时就需要新建一个哨兵结点
        ListNode dummy = new ListNode(-1);
        //快慢指针，每次快指针都会走到最后一个重复的元素
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            //如果fast遇到重复元素向后移动了
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            }
            //如果fast没有遇到重复元素则不会移动，slow和fast依次向后移动一格
            else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;

    }
}
