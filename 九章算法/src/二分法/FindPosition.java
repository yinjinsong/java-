package 二分法;

public class FindPosition {
    public static void main(String[] args) {
        System.out.println(findPosition(new int[]{1, 2, 2, 4, 5, 5}, 5));
    }
    public static int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //寻找first符合位置的
//        while (left + 1 < right) {
//            int mid = left + (right - left) /2 ;
//            if (nums[mid] < target) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }
//        if (nums[left] == target) {
//            return left;
//        } else if (nums[right] == target) {
//            return right;
//        } else {
//            return -1;
//        }
        //寻找last符合的
        while (left + 1 < right) {
            int mid = left + (right - left) /2 ;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
