public class Num53在排序数组中查找数字1 {
    public int search(int[] nums, int target) {
        if(nums.length==0) return 0;
        //两次二分
        int left = 0, right = nums.length - 1;
        int l, r = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(target<=nums[mid]) right = mid;
            else left = mid;
        }
        if(nums[left]==target) l = left;
        else if(nums[right]==target) l = right;
        else return 0;

        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(target<nums[mid]) right = mid;
            else left = mid;
        }
        if(nums[right]==target) r = right;
        else if(nums[left]==target) r = left;

        return r - l + 1;

    }
}
