public class Num0810颜色填充 {
    public int[][] floodFill(int[][] image, int x, int y, int newColor) {
        dfs(image, x, y, image[x][y]);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == '/') image[i][j] = newColor;
            }
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int target) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != target) return;
        image[x][y] = '/';
        dfs(image, x + 1, y, target);
        dfs(image, x - 1, y, target);
        dfs(image, x, y + 1, target);
        dfs(image, x, y - 1, target);
    }
}
