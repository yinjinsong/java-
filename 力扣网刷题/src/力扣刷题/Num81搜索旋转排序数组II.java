package 力扣刷题;

//这种有重复数字的题目，就需要判断边界和mid的值相等的情况下，边界需要收缩一下。
//先确定mid和边界的关系能找到有序的一部分，然后判断target是否在有序的这一部分，如果是则收缩边界。
//如果不是则向另一边收缩。
public class Num81搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return true;
        } else if (nums[right] == target) {
            return true;
        } else {
            return false;
        }
    }
}
