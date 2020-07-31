package 力扣刷题;

public class Num34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if(nums.length==0) return ans;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]<target) left = mid;
            else right = mid;
        }
        if(nums[left]==target) ans[0] = left;
        else if(nums[right]==target) ans[0] = right;
        else return ans;

        left = 0;
        right = nums.length - 1;
        //找最后一个等于target的数
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]<=target) left = mid;
            else right = mid;
        }
        if(nums[right]==target) ans[1] = right;
        else ans[1] = left;
        return ans;
    }

}
