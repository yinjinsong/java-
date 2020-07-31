package singlelinkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 单链表的实现
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        //新建结点
        Student student1 = new Student(1,"松儿松");
        Student student2 = new Student(2,"连大壮");
        Student student3 = new Student(3,"连翠翠");
        Student student4 = new Student(4, "狗松");
        StudentNode node1 = new StudentNode(student1);
        StudentNode node2 = new StudentNode(student2);
        StudentNode node3 = new StudentNode(student3);
        StudentNode node4 = new StudentNode(student4);
        StudentNode node5 = new StudentNode(new Student(5, "嘻嘻嘻"));

        //添加结点

//        list.add(node1);
//        list.add(node2);
//        list.add(node3);
//        list.add(node4);
        //Student student10 = new Student(5,"连22");
        // StudentNode studentNode = new StudentNode(student10);
        list.addByOrder(node1);
        list.addByOrder(node2);
        list.addByOrder(node3);
        list.addByOrder(node4);
        list.addByOrder(node5);
        list.show();
        //list.update(studentNode);

        //遍历打印结点

        //删除结点
//        list.delete(5);
//        list.delete(7);
//        list.delete(8);
//        list.delete(9);
//        list.show();

        System.out.println("链表长度为:" + list.size());
        System.out.println("链表倒数第5个结点为"+list.getLastkNode(5));
        System.out.println("链表反转后");
        list.reverse();
        System.out.println(list.getHead().next);
        list.show();
        System.out.println("链表反向打印1");
        list.reversePrint1();
        System.out.println("链表反向打印2");
        list.reversePrint2();
    }
}

class SingleLinkedList{
    //带头结点的链表
    private StudentNode head = new StudentNode(new Student(0, "头结点"));

    public StudentNode getHead() {
        return head;
    }

    /**
     * 向链表末尾添加结点
     * @param node
     */
    public void add(StudentNode node) {
        //需要遍历到最后一个结点，然后将他的next指针指向需要添加的结点
        StudentNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    /**
     * 按编号顺序添加
     * @param node
     */
    public void addByOrder(StudentNode node) {
        StudentNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.student.id < node.student.id) {
                tmp = tmp.next;
            } else if (tmp.next.student.id == node.student.id) {
                throw new RuntimeException("编号已存在！插入失败");
            } else {
                node.next = tmp.next;
                tmp.next = node;
                break;
            }
        }
        //如果遍历完了tmp在最后一个结点，说明链表中的数据都比待插入结点小
        if (tmp.next == null) {
            tmp.next = node;
        }
    }

    /**
     * 根据结点序号更新结点
     * @param node
     */
    public void update(StudentNode node) {
        /*
            1.遍历当前列表查找对应编号的结点是否存在
            2.如果结点存在，则更新当前结点打data域中的数据
            3.如果结点不存在则打印提示信息
         */
        boolean flag = false;
        int id = node.student.id;
        StudentNode tmp = head;
        while (tmp != null) {
            if (tmp.student.id == node.student.id) {
                tmp.student.name = node.student.name;
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!flag) {
            System.out.println("没有找到对应结点的编号");
        }
    }

    /**
     * 遍历结点找到待删除的结点
     * 保存下一个结点信息，在将上一个结点的next指向下一个结点
     * @param num
     */
    public void delete(int num) {
        boolean flag = false;
        StudentNode tmp = head;
        while (tmp.next != null) {
            int id = tmp.next.student.id;
            if (id == num) {
                //获取下一个结点
                StudentNode nextNode = tmp.next.next;
                //将上一个结点和下一个结点连接
                tmp.next = nextNode;
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!flag) {
            System.out.println("未找到指定的删除对象");
        }

    }

    /**
     * 获取链表的有效长度，头结点不算
     * @return
     */
    public int size() {
        int size = 0;
        StudentNode tmp = head.next;
        if (tmp == null) {
            return size;
        }
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }

    /**
     * 获取链表的倒数第k个结点
     * @return
     */
    public StudentNode getLastkNode(int k) {
        StudentNode first = head.next;
        StudentNode second = head.next;
        int size = this.size();
        if (k > size || k <= 0) {
            throw new RuntimeException("参数错误，超过链表长度或者小于0");
        }
        for (int i = 0; i < k; i++) {
            second = second.next;
        }
        while (second != null) {
            second = second.next;
            first = first.next;
        }
        return first;
    }

    /**
     * 单链表的反转
     */
    public void reverse() {
        StudentNode curNode = head.next;
        StudentNode preNode = null;
        StudentNode nextNode = null;
        while (curNode != null) {
            //保存当前结点的下一个结点信息
            nextNode = curNode.next;
            curNode.next = preNode;

            //向后平移
            preNode = curNode;
            curNode = nextNode;
        }
        //反转完之后将头结点街上
        head.next = preNode;
    }

    /**
     * 从尾到头打印链表1
     */
    public void reversePrint1() {
        StudentNode tmp = head.next;
        ArrayList<StudentNode> list = new ArrayList<>();
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        Collections.reverse(list);
        for (StudentNode studentNode : list) {
            System.out.println(studentNode);
        }
    }

    /**
     * 从尾到头打印链表2（利用stack）
     */
    public void reversePrint2() {
        StudentNode tmp = head.next;
        Stack<StudentNode> stack = new Stack<>();
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    /**
     * 打印链表
     * 头结点不能动，需要辅助指针变量接一下
     */
    public void show() {
        StudentNode tmp = head.next;
        if (tmp == null) {
            System.out.println("链表为空");
        }
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }

    }

}

class StudentNode{
    public Student student;
    public StudentNode next;

    public StudentNode(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "student=" + student +
                '}';
    }
}

class Student{
    public int  id;
    public String name;


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}