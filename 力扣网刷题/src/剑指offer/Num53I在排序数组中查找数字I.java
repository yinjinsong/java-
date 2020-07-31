package 剑指offer;

public class Num53I在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int firstIndex = binarySearch(nums, 0, nums.length - 1, target);
        int lastIndex = binarySearch2(nums, 0, nums.length - 1, target);
        if (firstIndex == -1) {
            return 0;
        } else {
            return lastIndex - firstIndex + 1;
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    private int binarySearch2(int[] nums, int left, int right, int target) {

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
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
