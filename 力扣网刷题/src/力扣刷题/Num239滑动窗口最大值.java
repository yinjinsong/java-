package 力扣刷题;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Num239滑动窗口最大值 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = k - 1;
        while (right < nums.length) {
            int ans = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if(nums[i]>ans) ans = nums[i];
            }
            list.add(ans);
            left++;
            right++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public  int[] maxSlidingWindow2(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && i - k + 1 > q.peekFirst()) q.pollFirst();
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
            q.offerLast(i);
            if (i >= k - 1) list.add(nums[q.peekFirst()]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
