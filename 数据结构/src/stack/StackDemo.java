package stack;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
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
                    stack.show();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入需要压栈的数：");
                    int num = scanner.nextInt();
                    try {
                        stack.push(num);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
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

class Stack{
    private int maxSize;//最大容量
    private int[] stack;//存储数据的数组
    private int top = -1;//栈顶

    /**
     * 构造方法，传入最大容量
     * @param maxSize
     */
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈是否已经满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 压栈操作
     * @param num
     */
    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈满，无法继续压入数据！");
        }
        top++;
        stack[top] = num;
    }

    /**
     * 出栈操作
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法取出数据！");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 打印栈
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈是空的~~");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]:%d\n", i, stack[i]);
        }
    }


}
