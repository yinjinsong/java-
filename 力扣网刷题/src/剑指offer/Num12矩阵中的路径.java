package 剑指offer;

public class Num12矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int k) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || word.charAt(k) != board[i][j]) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        //1下2上3右4左
        boolean ans = dfs(i + 1, j, board, word, k + 1) || dfs(i - 1, j, board, word, k + 1)
                || dfs(i, j + 1, board, word, k + 1) || dfs(i, j - 1, board, word, k + 1);
        //恢复board
        board[i][j] = temp;
        return ans;
    }


}
