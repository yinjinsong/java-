package 剑指offer;

import java.util.HashMap;

public class Num35复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node pre = dummy;
        Node newNode;
        while (head != null) {
            //先复制结点
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new Node(head.val);
                map.put(head, newNode);
            }
            pre.next = newNode;
            //再复制随机结点
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new Node(head.random.val);
                    map.put(head.random, newNode.random);
                }
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

    //1->1'->2->2'->3->3'
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        //复制next
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        //复制random
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        //分离两个链表
        Node dummy = new Node(0);
        Node pre = dummy;
        p = head;
        while (p != null) {
            Node curNode = p.next;
            p.next = curNode.next;
            pre.next = curNode;

            pre = pre.next;
            p = p.next;
        }
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
