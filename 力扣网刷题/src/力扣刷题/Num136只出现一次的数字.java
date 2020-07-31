package 力扣刷题;

public class Num136只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

    //面试题56-1
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        //寻找最低位的1用来将两个数分到不同组
        int bit = 1;
        while ((bit & sum) != bit) {
            bit <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & bit) == bit) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
