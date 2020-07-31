package 剑指offer;

public class Num29顺时针打印矩阵 {
    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int[] ans = new int[(right + 1) * (bottom + 1)];
        int index = 0;
        while (true) {
            //从左到右
            for (int i = left; i <= right; i++) {
                ans[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            //从上到下
            for (int i = top; i <= bottom; i++) {
                ans[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            //从右到左
            for (int i = right; i >= left; i--) {
                ans[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            //从下到上
            for (int i = bottom; i >= top; i--) {
                ans[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
