package 二分法;

public class SearchMatrix {
    public static void main(String[] args) {

    }
    //可以转成递增的一维数组二分比较
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (target < matrix[row][col]) {
                row--;
            } else if (target == matrix[row][col]) {
                return true;
            } else {
                col++;
            }
        }
        return false;
    }
}
