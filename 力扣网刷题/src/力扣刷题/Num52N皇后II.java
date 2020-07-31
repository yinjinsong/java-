package 力扣刷题;

public class Num52N皇后II {
    int ans = 0;
    //是否是同一列
    boolean[] col;
    //是否是同一主对角线
    boolean[] diag1;
    //是否是同一副对角线
    boolean[] diag2;

    public int totalNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        dfs(n, 0);
        return ans;
    }

    private void dfs(int n, int start) {
        if (start == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || diag1[start + i] || diag2[start - i + n - 1]) {
                continue;
            }
            col[i] = diag1[start + i] = diag2[start - i + n - 1] = true;
            dfs(n, start + 1);
            col[i] = diag1[start + i] = diag2[start - i + n - 1] = false;
        }
    }
}












