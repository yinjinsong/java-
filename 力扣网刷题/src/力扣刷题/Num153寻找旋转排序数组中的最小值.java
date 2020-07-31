package 力扣刷题;


public class Num153寻找旋转排序数组中的最小值{
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 3, 4, 5, 1}));
    }
    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //最小的数是第一个小于右边界的数
        int left = 0;
        int right = nums.length - 1;
        int rightNum = nums[right];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > rightNum) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
