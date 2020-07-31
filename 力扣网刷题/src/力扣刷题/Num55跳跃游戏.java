package 力扣刷题;

public class Num55跳跃游戏 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
    //dp
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (dp[j] && (i - j) <= nums[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
    //贪心
    public static boolean canJump2(int[] nums) {
        int fastest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //i能到达且当前下标最远长度可以更新
            if (i <= fastest && nums[i] + i >= fastest) {
                fastest = nums[i] + i;
            }
        }
        return fastest >= nums.length - 1;
    }
}
