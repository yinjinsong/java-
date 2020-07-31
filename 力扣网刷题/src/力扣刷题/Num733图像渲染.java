package 力扣刷题;

public class Num733图像渲染 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor, target, visited);
        return image;
    }

    private void dfs(int[][] image,
                     int row, int col,
                     int newColor,
                     int target,
                     boolean[][] visited) {
        if (row < 0 || row >= image.length
                || col < 0 || col >= image[0].length
                || image[row][col] != target || visited[row][col]) {
            return;
        }
        image[row][col] = newColor;
        visited[row][col] = true;
        //上
        dfs(image, row - 1, col, newColor, target, visited);
        //下
        dfs(image, row + 1, col, newColor, target, visited);
        //左
        dfs(image, row, col - 1, newColor, target, visited);
        //右
        dfs(image, row, col + 1, newColor, target, visited);
    }
}
