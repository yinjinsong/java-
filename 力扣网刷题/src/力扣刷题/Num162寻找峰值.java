package 力扣刷题;

public class Num162寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + right >>> 1;
            if(nums[mid]<nums[mid+1]) left = mid;
            else right = mid;
        }
        return nums[left] > nums[right] ? left : right;
    }
}
