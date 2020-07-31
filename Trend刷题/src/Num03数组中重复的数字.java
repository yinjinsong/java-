import java.util.HashMap;

public class Num03数组中重复的数字 {
    public static void main(String[] args) {
        findRepeatNumber2(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
    }
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            if(count>=1) return nums[i];
            map.put(nums[i], count + 1);
        }
        return 0;
    }

    public static int findRepeatNumber2(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) if(++arr[num]>1) return num;
        return 0;
    }
}
