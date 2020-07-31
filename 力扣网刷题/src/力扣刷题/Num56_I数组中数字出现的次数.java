package 力扣刷题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Num56_I数组中数字出现的次数 {
    //暴力法
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[2];
        ans[0] = list.get(0);
        ans[1] = list.get(1);
        return ans;
    }


    public int[] singleNumbers2(int[] nums) {
        int result = 0;
        //找出两个不同的数异或的结果
        for (int num : nums) {
            result ^= num;
        }
        int first1 = 1;
        while ((result & first1) == 0) {
            first1 <<= 1;
        }
        //此时first1就是第一位上为1的数，按这个位置分组
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & first1) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};


    }
}
