package 力扣刷题;

public class Num79单词搜索dfs {
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        char[] arr = word.toCharArray();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == arr[0]) {
                    if (dfs(board, arr, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,
                        char[] arr,
                        boolean[][] visited,
                        int i, int j, int k) {
        if (k == arr.length) {
            return true;
        }
        if (i < 0 || i >= row
                || j < 0 || j >= col
                || board[i][j] != arr[k]
                || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(board, arr, visited, i - 1, j, k + 1)
                || dfs(board, arr, visited, i + 1, j, k + 1)
                || dfs(board, arr, visited, i, j + 1, k + 1)
                || dfs(board, arr, visited, i, j - 1, k + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

}
