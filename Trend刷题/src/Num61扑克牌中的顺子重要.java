import java.util.Arrays;

public class Num61扑克牌中的顺子重要 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0, gap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (nums[i + 1] == nums[i]) return false;
            if (nums[i + 1] - nums[i] > 1) gap += nums[i + 1] - nums[i] - 1;
        }
        return zeroCount >= gap;
    }
}
