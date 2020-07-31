package 力扣刷题;

import java.util.Stack;

public class mianshi栈排序 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(5);
        stack.push(6);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> helperStack = new Stack<>();
        while (!stack.isEmpty()) {
            //先取出当前栈顶元素暂存
            int temp = stack.pop();
            //如果辅助栈不为空，且当前元素小于辅助栈顶元素，那么需要将辅助栈顶元素压回主栈
            while (!helperStack.isEmpty() && temp < helperStack.peek()) {
                stack.push(helperStack.pop());
            }
            //将当前元素压入辅助栈
            helperStack.push(temp);
        }
        //将逆序的辅助栈依次压回主栈
        while (!helperStack.isEmpty()) {
            stack.push(helperStack.pop());
        }
    }
}
