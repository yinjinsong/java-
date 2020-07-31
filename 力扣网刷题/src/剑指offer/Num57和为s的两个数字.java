package 剑指offer;

import java.util.HashSet;

public class Num57和为s的两个数字 {
    //o(n)的空间
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
            set.add(num);
        }
        return new int[]{-1, -1};
    }
    //双指针
    public int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
