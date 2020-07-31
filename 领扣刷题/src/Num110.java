/*
110. 最小路径和
中文English
给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。

样例
样例 1:
	输入:  [[1,3,1],[1,5,1],[4,2,1]]
	输出: 7

	样例解释：
	路线为： 1 -> 3 -> 1 -> 1 -> 1。
样例 2:
	输入:  [[1,3,2]]
	输出:  6

	解释:
	路线是： 1 -> 3 -> 2
 */
public class Num110 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //第一列先计算出来
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //第一行也计算出来
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
