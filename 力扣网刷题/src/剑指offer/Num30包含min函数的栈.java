package 剑指offer;

import java.util.Stack;

public class Num30包含min函数的栈 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
//    public MinStack() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.empty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())) {
            stack2.pop();
        }

    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
