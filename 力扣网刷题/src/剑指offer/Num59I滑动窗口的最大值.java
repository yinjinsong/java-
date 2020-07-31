package 剑指offer;

import java.util.ArrayList;

public class Num59I滑动窗口的最大值 {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = left + k - 1;
        while (right < nums.length) {
            list.add(findMax(nums, left, k));
            left++;
            right++;
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ans[i++] = integer;
        }
        return ans;
    }

    private static int findMax(int[] nums, int left, int k) {
        int maxVal = nums[left];
        for (int i = left + 1; i < left + k; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }
        return maxVal;

    }
}
