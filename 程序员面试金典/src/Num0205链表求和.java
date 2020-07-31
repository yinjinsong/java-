public class Num0205链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1, num2, carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            carry = num1 + num2 + carry;
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}
