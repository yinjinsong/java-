package 力扣刷题;

import java.util.Stack;

public class mianshi0305栈排序 {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    public mianshi0305栈排序() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void pop() {
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
        } else {
            while (!stack.isEmpty() && stack.peek() < val) {
                helper.push(stack.pop());
            }
            stack.push(val);
        }
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    public int peek() {
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && helper.isEmpty();
    }
}
