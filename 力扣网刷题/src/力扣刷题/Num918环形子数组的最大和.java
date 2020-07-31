package 力扣刷题;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Num918环形子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    }

    public static int maxSubarraySumCircular(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = A.length;
        for (int i = 0; i < 2; i++) {
            for (int i1 : A) list.add(i1);
        }
        int[] preSum = new int[2 * n + 1];

        for (int i = 1; i <= 2 * n; i++) {
            preSum[i] = preSum[i - 1] + list.get(i - 1);
        }
        int ans = Integer.MIN_VALUE;
        Deque<Integer> q = new LinkedList<>();
        q.offerLast(0);
        for (int i = 1; i <= 2 * n; i++) {
            if (!q.isEmpty() && i - n > q.peekFirst()) q.pollFirst();
            if (!q.isEmpty()) ans = Math.max(ans, preSum[i] - preSum[q.peekFirst()]);
            while (!q.isEmpty() && preSum[q.peekLast()] >= preSum[i]) q.pollLast();

            q.offerLast(i);
        }
        return ans;
    }
}
