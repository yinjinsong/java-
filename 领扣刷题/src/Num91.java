/*
找出一个序列中乘积最大的连续子序列（至少包含一个数）。

样例
样例 1:

输入:[2,3,-2,4]
输出:6
样例 2:

输入:[-1,2,4,1]
输出:8
 */
public class Num91 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4, -3, -2}));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }

        /*
            此题的状态转移比求最大和情况多一点
            最大值可能有3种情况取到
            1.nums[n]为负数，则取前面最小乘积×nums[n]
            2.如果nums[n]为正数，则取前面最大乘积和×nums[n]
            3.nums[n]本身
         */
        int n = nums.length;
        int maxValue = nums[0];
        //最大乘积
        int[] f = new int[n];
        //最小乘积
        int[] g = new int[n];

        int ans = nums[0];
        f[0] = nums[0];
        g[0] = nums[0];

        for (int i = 1; i < n; i++) {
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);

            ans = Math.max(ans, f[i]);
        }

        return ans;
    }
}
