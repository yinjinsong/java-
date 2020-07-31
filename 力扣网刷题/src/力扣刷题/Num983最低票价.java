package 力扣刷题;

public class Num983最低票价 {
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }
    public static int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }

//        int n = days.length;
//        //序列型动态规划，开最大天数+1的长度数组
//        int[] dp = new int[days[n - 1] + 1];
//        //days的当前下标位置
        int pos = 0;
        int n = days.length;
        int last = days[n - 1];
        int[] dp = new int[last + 1];
        //初始化
        dp[0] = 0;
        //状态转移
        for (int i = 1; i < dp.length; i++) {
            //当天要出行
            if (i == days[pos]) {
                //一天前的费用
                int day1 = i - 1;
                //七天前的费用
                int day2 = i - 7 > 0 ? i - 1 : 0;
                //三十天前的费用
                int day3 = i - 30 > 0 ? i = 30 : 0;
                dp[i] = Math.min(dp[day1] + costs[0], Math.min(dp[day2] + costs[1], dp[day3] + costs[2]));
                //到days[]中的下个出行日期
                pos++;
            }
            //当天不出行则费用是上一天的费用
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
    public static int mincostTickets2(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }
        int n = days.length;
        int last = days[n - 1];
        int[] dp = new int[last + 1];
        int pos = 0;
        //初始化
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i == days[pos]) {
                int day1 = i - 1;
                int day2 = i - 7 > 0 ? i - 7 : 0;
                int day3 = i - 30 > 0 ? i - 30 : 0;
                dp[i] = Math.min(dp[day1] + costs[0], Math.min(dp[day2] + costs[1], dp[day3] + costs[2]));
                pos++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[last];
    }
}
