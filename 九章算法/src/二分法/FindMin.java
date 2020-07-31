package 二分法;

public class FindMin {
    public static void main(String[] args) {

    }
    //o(n)
//    public static int findMin(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int minVal = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < minVal) {
//                minVal = nums[i];
//            }
//        }
//        return minVal;
//
//    }
    //o(logn)二分法 4,5,6,7,8,1,2,3
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //要查找的数可以看做first小于等于最右边的数
        int left = 0;
        int right = nums.length - 1;
        int target = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            //先排除掉判断不满足的一部分
            if (nums[mid] > target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] <= target) {
            return nums[left];
        } else {
            return nums[right];
        }


    }
}
