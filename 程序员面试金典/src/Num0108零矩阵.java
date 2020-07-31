import java.util.HashSet;

public class Num0108零矩阵 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Integer integer : row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[integer][i] = 0;
            }
        }
        for (Integer integer : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        }
    }

    private void dfs(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[x][i] = -1;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = -1;
        }
    }
}
