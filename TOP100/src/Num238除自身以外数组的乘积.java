public class Num238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0, res = 1; i < nums.length; i++) {
            ans[i] = res;
            res *= nums[i];
        }
        for (int i = nums.length - 1, res = 1; i >= 0; i--) {
            ans[i] *= res;
            res *= nums[i];
        }
        return ans;
    }
}
