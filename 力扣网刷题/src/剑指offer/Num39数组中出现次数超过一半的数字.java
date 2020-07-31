package 剑指offer;

public class Num39数组中出现次数超过一半的数字 {

    public int majorityElement(int[] nums) {
        int baseNum = 0;
        baseNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                baseNum = nums[i];
            }
            if (nums[i] == baseNum) {
                count++;
            } else {
                count--;
            }
        }
        return baseNum;
    }

}
