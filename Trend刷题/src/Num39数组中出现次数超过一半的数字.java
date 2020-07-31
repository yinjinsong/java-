import java.util.Arrays;

public class Num39数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int count = 0, target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
                count++;
            } else {
                if (nums[i] == target) count++;
                else count--;
            }
        }
        return target;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
