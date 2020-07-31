public class Num12矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == arr[0]) {
                    if (dfs(board, i, j, arr, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] arr, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != arr[index]) {
            return false;
        }
        if(index==arr.length-1) return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean ans = false;
        ans = dfs(board, i + 1, j, arr, index + 1) ||
                dfs(board, i - 1, j, arr, index + 1) ||
                dfs(board, i, j + 1, arr, index + 1) ||
                dfs(board, i, j - 1, arr, index + 1);
        board[i][j] = temp;
        return ans;
    }
}
