import java.util.ArrayList;
import java.util.Collections;

public class Num148排序链表 {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            list.add(cur.val);
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}