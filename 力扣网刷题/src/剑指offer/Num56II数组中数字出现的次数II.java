package 剑指offer;

public class Num56II数组中数字出现的次数II {
    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{3, 4, 3, 3}));
    }
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static int singleNumber2(int[] nums) {
        int[] arr = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                arr[31 - i] += num & 1;
                num >>>= 1;
            }
        }
        int ans = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= arr[i] % m;
        }
        return ans;
    }
}
