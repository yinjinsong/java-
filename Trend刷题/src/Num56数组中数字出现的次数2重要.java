public class Num56数组中数字出现的次数2重要 {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                //高位在0
                arr[j] += num & 1;
                num >>>= 1;
            }
        }
        int ans = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            //从低位开始算
            ans <<= 1;
            ans |= arr[31 - i] % m;
        }
        return ans;
    }
}
