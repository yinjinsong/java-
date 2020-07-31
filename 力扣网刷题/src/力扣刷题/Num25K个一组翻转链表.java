package 力扣刷题;

public class Num25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            //开始翻转的头结点
            ListNode start = pre.next;
            //保存断开前end的下一个结点
            ListNode next = end.next;
            //断开后面链表
            end.next = null;
            //此时要反转的区间就是[start..end]
            //将pre结点连接反转后的头结点
            pre.next = reverse(start);

            //重置pre和end
            pre = start;
            end = start;

            //连接后面的链表
            start.next = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
