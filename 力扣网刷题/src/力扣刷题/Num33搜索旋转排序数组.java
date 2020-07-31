package 力扣刷题;

public class Num33搜索旋转排序数组 {
    public static void main(String[] args) {
        search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }
    public static int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + right >>> 1;
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) left = mid;
                else right = mid;
            } else {
                if(nums[left]<=target&&target<=nums[mid]) right = mid;
                else left = mid;
            }
        }
        if(nums[left]==target) return left;
        else if(nums[right]==target) return right;
        else return -1;
    }
}
