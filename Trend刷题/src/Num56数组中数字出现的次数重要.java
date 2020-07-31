public class Num56数组中数字出现的次数重要 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int bit = 1;
        while ((sum & bit) != bit) {
            bit <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & bit) == bit) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }

}
