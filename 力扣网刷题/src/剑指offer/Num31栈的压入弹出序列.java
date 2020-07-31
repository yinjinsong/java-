package 剑指offer;

import java.util.Stack;

public class Num31栈的压入弹出序列 {
    //{1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        return stack.isEmpty();
    }
}
