public class Num494目标和 {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int sum) {
        dfs(nums, sum, 0);
        return ans;
    }

    private void dfs(int[] nums, int sum, int start) {
        if (start == nums.length) {
            if (sum == 0) ans++;
            return;
        }
        dfs(nums, sum - nums[start], start + 1);
        dfs(nums, sum + nums[start], start + 1);
    }
}
