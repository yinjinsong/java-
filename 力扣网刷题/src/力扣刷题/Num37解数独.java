package 力扣刷题;

public class Num37解数独 {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int t = c - '1';
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y) {
        if (y == 9) return dfs(board, x + 1, 0);
        if (x == 9) return true;
        if (board[x][y] == '.') {
            for (int i = 0; i < 9; i++) {
                if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                    char c = (char) (i + '1');
                    board[x][y] = c;
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                    if (dfs(board, x, y + 1)) return true;
                    board[x][y] = '.';
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
                }
            }
        } else {
            return dfs(board, x, y + 1);
        }
        return false;
    }
}
