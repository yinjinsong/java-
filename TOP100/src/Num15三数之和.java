import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num15三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) return list;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1, target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] < target) left++;
                else if (nums[left] + nums[right] == target) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else right--;
            }
        }
        return list;
    }

}
