public class Num59滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        int[] ans = new int[nums.length - k + 1];
        int left = 0, right = k - 1, max = Integer.MIN_VALUE, index = 0;
        while (right < nums.length) {
            for (int i = left; i <= right; i++) {
                max = Math.max(nums[i], max);
            }
            ans[index++] = max;
            max = Integer.MIN_VALUE;
            right++;
            left++;
        }
        return ans;
    }

}
