package 力扣刷题;

import java.util.Arrays;

public class Num354俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{1, 1}}));

    }
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);

        }
        return ans;
    }
}
