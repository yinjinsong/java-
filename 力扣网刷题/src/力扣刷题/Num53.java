package 力扣刷题;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/
public class Num53 {
    public static void main(String[] args) {
        int a=maxSubArray(new int[]{-2, 1});
        System.out.println(a);
    }
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int curMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < len; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            globalMax = Math.max(curMax, globalMax);
        }
        return globalMax;
    }
}
