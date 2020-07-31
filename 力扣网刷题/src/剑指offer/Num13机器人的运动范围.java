package 剑指offer;

public class Num13机器人的运动范围 {
    private boolean[][] visited;
    private int m,n, k;
    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m || j >= n || digitSum(i, j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    private int digitSum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

}
