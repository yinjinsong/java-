package 力扣刷题;

public class Num154寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int rightNum = nums[right];
            int mid = left + (right - left) / 2;
            if (nums[mid] > rightNum) {
                left = mid;
            }
            //这一步是不同，如果出现和右边界相等的值，那么需要收缩右边界。
            //因为这个值和右边界的值相等，所以去掉右边界不会去掉最小值
            else if (nums[mid] == rightNum) {
                right--;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
