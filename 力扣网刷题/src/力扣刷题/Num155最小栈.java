package 力扣刷题;

import java.util.Stack;

public class Num155最小栈 {
    class MinStack {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            //将stack2栈顶保存最小元素，取的时候就只需要O(1)的时间复杂度
            if (stack2.isEmpty() || x <= stack2.peek()) {
                stack2.push(x);
            }
        }
        public void pop() {
            //取s1的时候如果是s2的栈顶元素，相同就都需要取出
            if (stack1.pop().equals(stack2.peek())) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }


}
