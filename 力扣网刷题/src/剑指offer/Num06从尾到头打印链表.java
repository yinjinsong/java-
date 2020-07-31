package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class Num06从尾到头打印链表 {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        reversePrint2(head);

    }
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        return arr;

    }
    //递归
    public static int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        helper(head);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    public static void helper(ListNode head) {
        if (head == null) {
            return;
        }
        helper(head.next);
        list.add(head.val);
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}