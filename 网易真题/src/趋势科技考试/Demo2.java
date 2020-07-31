package 趋势科技考试;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        CircleSingleLinkedList list = new CircleSingleLinkedList();

        list.countBoy(1, 1, n);

    }
}
class CircleSingleLinkedList{
    PersonNode first = null;

    /**
     * 创建环形链表
     * @param nums 结点数
     */
    public void add(int nums) {
        if (nums <= 1) {
            throw new RuntimeException("参数小于1非法！");
        }
        PersonNode curNode = null;
        for (int i = 1; i <= nums; i++) {
            PersonNode personNode = new PersonNode(i);
            if (i == 1) {
                first = personNode;
                //指回头指针形成环
                curNode = personNode;
                curNode.next = first;
            } else {
                curNode.next = personNode;
                personNode.next = first;
                curNode = personNode;
            }

        }
    }



    /**
     * 计数游戏
     * @param startNum 从哪个编号开始
     * @param targetNum 需要报的数
     * @param PersonNum 总人数
     */
    public void countBoy(int startNum, int targetNum, int PersonNum) {
        /*
            先根据人数创建链表
            1.先遍历一遍环形链表，找到first的上一个结点
            1.将first指针和last指针移动startNum-1次，到达游戏开始的其实人员编号
            2.将first指针和last指针移动targetNum-1次，first所指向的位置就是出圈的位置
              将first.next先保存下来，然后将last.next连接上first.next
            3.当first.next=first时停止
         */
        if (targetNum > PersonNum) {
            targetNum = targetNum % PersonNum;
        }
        this.add(PersonNum);
        PersonNode curNode = first;
        PersonNode firstPreNode = null;
        //找到first的前一个指针
        for (int i = 1; i < PersonNum; i++) {
            curNode = curNode.next;
        }
        firstPreNode = curNode;
        //初始化到开始位置
        for (int i = 1; i < startNum; i++) {
            first = first.next;
            firstPreNode = firstPreNode.next;
        }
        //-----游戏开始-----//
        while (first != first.next) {
            targetNum++;
            for (int i = 1; i < targetNum; i++) {
                first = first.next;
                firstPreNode = firstPreNode.next;
            }
            firstPreNode.next = first.next;
            first = first.next;
        }
        System.out.println(firstPreNode.num);
    }

}

class PersonNode{

    public int num;
    public PersonNode next;

    public PersonNode(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "num=" + num +
                '}';
    }
}
