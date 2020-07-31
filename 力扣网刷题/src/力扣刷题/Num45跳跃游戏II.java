package 力扣刷题;

public class Num45跳跃游戏II {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    //和最长上升子序列思路一样,最后一步依赖于前面组合的结果,O(n2)超时
    public static int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //dp[i]表示跳到第i个格子上的最小花费步数
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            //将dp[i]初始化为最大值,便于更新
            dp[i] = nums.length;
            for (int j = 0; j < i; j++) {
                //如果第j个格子能跳过来
                if (i - j <= nums[j]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    //用贪心算法每次寻找能跳到范围内的最大值并更新
    public static int jump2(int[] nums) {
        int steps = 0;
        int start = 0;
        int end = 0;
        int maxPosition = 0;
        while (end < nums.length - 1) {
            steps++;
            for (int i = start; i <= end; i++) {
                if (nums[i] + i > maxPosition) {
                    maxPosition = nums[i] + i;
                }
            }
            start = end + 1;
            end = maxPosition;
        }
        return steps;
    }
}
