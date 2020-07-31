package 力扣刷题;

import java.util.HashMap;
import java.util.Map;

public class Num560和为K的子数组 {
    public static void main(String[] args) {
        System.out.println(subarraySum2(new int[]{1, 2, 3, 4, 5}, 7));
    }
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //固定左边界不动，从右边界开始枚举和
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int preSum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            ans += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
