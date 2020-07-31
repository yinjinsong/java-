import java.util.Stack;

public class Num31栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack1 = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack1.push(pushed[i]);
            while (!stack1.isEmpty() && stack1.peek() == popped[index]) {
                stack1.pop();
                index++;
            }
        }
        return stack1.isEmpty();
    }
}
