public class Num13机器人的运动范围 {
    int m,n,k, ans;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        dfs(0, 0);
        return ans;
    }

    private void dfs(int x, int y) {
        if(x>=m||y>=n||!digitsum(x,y,k)||visited[x][y]) return;
        visited[x][y] = true;
        ans++;
        dfs(x + 1, y);
        dfs(x, y + 1);
    }

    private boolean digitsum(int x, int y, int k) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }

}
