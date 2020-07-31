public class Num04二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int row = matrix.length, col = matrix[0].length;
        int x = row - 1, y = 0;
        while (x >= 0 && y < col) {
            if(target>matrix[x][y]) y++;
            else if(target<matrix[x][y]) x--;
            else return true;
        }
        return false;
    }
}
