package 力扣刷题;

import java.util.*;
import java.util.stream.Collectors;

public class Num84柱状图中最大的矩形 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea3(new int[]{2, 1, 5, 6, 2, 3}));
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        if (heights.length == 0) return ans;
        for (int i = 0; i < n; i++) {
            int curHeight = heights[i], left = i - 1, right = i + 1;
            while (left >= 0 && heights[left] >= curHeight) left--;
            while (right < n && heights[right] >= curHeight) right++;
            ans = Math.max(ans, curHeight * (right - left - 1));
        }
        return ans;
    }


    public int largestRectangleArea2(int[] heights) {
        //int数组转list
        List<Integer> list = Arrays.stream(heights).boxed().collect(Collectors.toList());
        list.add(-1);
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) < list.get(stack.peek())) {
                int h = list.get(stack.pop());
                if (stack.isEmpty()) ans = Math.max(ans, i * h);
                else ans = Math.max(ans, h * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return ans;
    }


    public static int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if (stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
        while (!stack.isEmpty()) stack.pop();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if (stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }



}
