package 力扣刷题;

import java.util.Stack;

public class Num42接雨水 {

    public  int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int last = 0;
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int t = stack.pop();
                ans += (i - t - 1) * (height[t] - last);
                last = height[t];
            }
            if(!stack.isEmpty()) ans += (i - stack.peek() - 1) * (height[i] - last);
            stack.push(i);
        }
        return ans;
    }
}
