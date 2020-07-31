package 剑指offer;

import java.util.HashSet;

public class Num52两个链表的第一个公共结点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curNodeA = headA;
        ListNode curNodeB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curNodeA != null) {
            curNodeA = curNodeA.next;
            lenA++;
        }
        while (curNodeB != null) {
            curNodeB = curNodeB.next;
            lenB++;
        }
        curNodeA = headA;
        curNodeB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curNodeA = curNodeA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                curNodeB = curNodeB.next;
            }
        }
        while (curNodeA != null) {
            if (curNodeA != curNodeB) {
                curNodeA = curNodeA.next;
                curNodeB = curNodeB.next;
            } else {
                return curNodeA;
            }
        }
        return null;

    }

    //方法二、hashset存储结点，判断另一个链表从什么结点开始存在
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        HashSet<ListNode> set = new HashSet<>();
        while (pa != null) {
            set.add(pa);
            pa = pa.next;
        }
        while (pb != null) {
            if (set.contains(pb)) {
                return pb;
            }
            pb = pb.next;
        }
        return null;
    }

    //方法三
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
            if (pa == null && pb == null) {
                return null;
            }
            if (pa == null) {
                pa = headB;
            }
            if (pb == null) {
                pb = headA;
            }
        }
        return pa;
    }
}

