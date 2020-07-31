package 力扣刷题;

public class Num81 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1,1},3));
    }
    public static boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return  false;
        }
        int left=0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= nums[right]) {
                //落在有序区间
                if (nums[mid+1] <= target && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }else{
                //落在有序区间
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                }else{
                    left=mid+1;
                }
            }
        }
        if (nums[left] == target) {
            return true;
        }
        return false;
    }
}
