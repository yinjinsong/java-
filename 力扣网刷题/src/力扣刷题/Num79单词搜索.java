package 力扣刷题;

public class Num79单词搜索 {
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        char[] arr = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == arr[0]) {
                    if (dfs(board, arr, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, char[] arr, int i, int j, int k) {
        if (k == arr.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != arr[k]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        if (dfs(board, arr, i - 1, j, k + 1)
                || dfs(board, arr, i + 1, j, k + 1)
                || dfs(board, arr, i, j - 1, k + 1)
                || dfs(board, arr, i, j + 1, k + 1)) {
            return true;
        }
        board[i][j] = tmp;
        return false;

    }
}
