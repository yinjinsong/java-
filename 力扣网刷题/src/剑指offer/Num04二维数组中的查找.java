package 剑指offer;

public class Num04二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (target > matrix[row][col]) {
                col++;
            } else if (target == matrix[row][col]) {
                return true;
            } else {
                row--;
            }
        }
        return false;

    }
}
