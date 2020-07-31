import java.util.Stack;

public class Num30包含min函数的栈 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Num30包含min函数的栈() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack2.isEmpty() || x <= stack2.peek()) stack2.push(x);
        stack1.push(x);
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())) stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
