package stack;

import java.util.Scanner;

public class StacKLinkedListDemo {
    public static void main(String[] args) {
        Stack2 stack2 = new Stack2();
        String key = "";
        boolean loop = true;
        while (loop) {
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示加入数据到栈（入栈）");
            System.out.println("pop:表示从栈中取出数据（出栈）");
            System.out.println("请输入你的选择");
            Scanner scanner = new Scanner(System.in);
            key = scanner.next();
            switch (key) {
                case "show":
                    stack2.show();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入需要压栈的数：");
                    int num = scanner.nextInt();
                    try {
                        stack2.push(num);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "pop":
                    try {
                        int pop = stack2.pop();
                        System.out.println("出栈的数据是：" + pop);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

        }
        System.out.println("退出程序~~~");
    }
}

class Stack2 {
    private LinkList linkList;

    public Stack2() {
        this.linkList = new LinkList();
    }
    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.linkList.isEmpty();
    }

    /**
     * 压栈
     * @param num
     */
    public void push(int num) {
        this.linkList.insertFirst(new Node(num));
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        return this.linkList.delFirst();
    }

    /**
     * 打印栈
     */
    public void show() {
        this.linkList.show();
    }
}

/**
 * 栈的底层链表结构
 */
class LinkList {
    private Node head = new Node(-1);//带头结点的链表

    public Node getHead() {
        return head;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 插入头结点的后面
     * @param node
     */
    public void insertFirst(Node node) {
        /*
            1.先保存下一个结点
            2.将head.next指向node
            3.将node.next指向下一个结点
         */
        Node cur = head;
        Node next = head.next;
        cur.next = node;
        node.next = next;
    }

    /**
     * 删除头结点后的第一个结点
     * @return
     */
    public int delFirst() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法取数据！");
        }
        Node cur = head;
        int data = cur.next.data;
        cur.next = cur.next.next;
        return data;
    }

    /**
     * 打印链表
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空~~~");
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            System.out.println(cur.next);
            cur = cur.next;
        }
    }
}

/**
 * 链表的底层单个结点
 */
class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

