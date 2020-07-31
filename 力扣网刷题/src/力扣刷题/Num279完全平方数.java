package 力扣刷题;

import java.util.*;

public class Num279完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares2(82));
    }
    public static int numSquares(int n) {
        //dp[i]代表i组成完全平方数的最少个数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    //BFS
    public static int numSquares2(int n) {
        //dist[i]表示0到i的最小距离(最少需要几个平方数）
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == n) {
                return dist[temp];
            }
            //存储temp所在位置的下一步能到达的所有距离
            for (int i = 1; temp + i * i <= n; i++) {
                int j = temp + i * i;
                if (dist[j] > dist[temp] + 1) {
                    dist[j] = dist[temp] + 1;
                    queue.offer(j);
                }
            }
        }
        return 0;
    }

}
