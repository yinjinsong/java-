public class Num21调整数组顺序使奇数位于偶数前面重点 {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) return nums;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            if (left < right) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
        }
        return nums;
    }
}
