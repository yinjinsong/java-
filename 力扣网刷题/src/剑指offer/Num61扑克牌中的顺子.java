package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Num61扑克牌中的顺子 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0, 0, 2, 2, 5}));
    }
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                list.add(nums[i]);
            }
        }


        int dis = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1)) {
                return false;
            }
            if (list.get(i) - list.get(i - 1) > 1) {
                dis += list.get(i) - list.get(i - 1) - 1;
            }
        }

        return count >= dis;
    }

    //只需要比较除0外最大值和最小值差距是否小于5
    public static boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int jokerCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                jokerCount++;
                continue;
            }
            if (nums[i + 1] != nums[i]) {
                return false;
            }
        }
        return nums[4] - nums[jokerCount] < 5;
    }
}
