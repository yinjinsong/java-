public class Num29顺时针打印矩阵重点 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int[] ans = new int[(right + 1) * (bottom + 1)];
        int index = 0;
        while (true) {
            for (int i = left; i <= right; i++) ans[index++] = matrix[top][i];
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) ans[index++] = matrix[i][right];
            if (--right < left) break;
            for (int i = right; i >= left; i--) ans[index++] = matrix[bottom][i];
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) ans[index++] = matrix[i][left];
            if (++left > right) break;
        }
        return ans;
    }
}