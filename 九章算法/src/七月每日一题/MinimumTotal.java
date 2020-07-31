package 七月每日一题;

/*
给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。

样例
样例 1

输入下列数字三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
输出： 11
解释： 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
样例 2

输入下列数字三角形：
[
     [2],
    [3,2],
   [6,5,7],
  [4,4,8,1]
]
输出： 12
解释： 从顶到底部的最小路径和为12 ( 2 + 2 + 7 + 1 = 12)。
 */
public class MinimumTotal {
    public static void main(String[] args) {

    }
    public int minimumTotal(int[][] triangle) {
        int m = triangle.length;
        int n = triangle[0].length;
        //dp[i][j]存放的是从顶点到该结点的最小路径
        int[][] dp = new int[m][n];
        return 0;
        //dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + triangle[i][j];
    }
}
