package 力扣刷题;

public class Num35插入搜索位置 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0||nums[nums.length-1]<target) return nums.length;
        int left = 0, right = nums.length - 1;
        //寻找第一个大于等于target的数
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid;
            else if (nums[mid] == target) return mid;
            else right = mid;
        }
        if(nums[left]>=target) return left;
        return right;
    }
}
