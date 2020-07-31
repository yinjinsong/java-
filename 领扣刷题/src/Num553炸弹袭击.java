public class Num553炸弹袭击 {
    //暴力法，枚举每一个空地能炸死的最大人数
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int count = 0;
                    //朝四个方向搜索
                    //1.向右搜索
                    for (int k = j; k < n; k++) {
                        if (grid[i][k] == 'E') {
                            count++;
                        } else if (grid[i][k] == 'W') {
                            break;
                        }
                    }
                    //2.向下搜索
                    for (int k = i; k < m; k++) {
                        if (grid[k][j] == 'E') {
                            count++;
                        } else if (grid[k][j] == 'W') {
                            break;
                        }
                    }
                    //3.向左搜索
                    for (int k = j; k >= 0; k--) {
                        if (grid[i][k] == 'E') {
                            count++;
                        } else if (grid[i][k] == 'W') {
                            break;
                        }
                    }
                    //4.向上搜索
                    for (int k = i; k >= 0; k--) {
                        if (grid[k][j] == 'E') {
                            count++;
                        } else if (grid[k][j] == 'W') {
                            break;
                        }
                    }
                    if (count > ans) {
                        ans = count;
                    }
                }
            }
        }
        return ans;
    }
    //采用dp优化
    public int maxKilledEnemies2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int t = 0;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        //向上炸死的敌人数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        up[i][j] = 1;
                    }
                    if (i - 1 >= 0) {
                        up[i][j] += up[i - 1][j];
                    }
                }

            }
        }
        //向右炸死的敌人数
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        right[i][j] = 1;
                    }
                    if (j + 1 < n) {
                        right[i][j] += right[i][j + 1];
                    }
                }

            }
        }
        //向下炸死的敌人数
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        down[i][j] = 1;
                    }
                    if (i + 1 < m) {
                        down[i][j] += down[i + 1][j];
                    }
                }

            }
        }
        //向左炸死的敌人数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        left[i][j] = 1;
                    }
                    if (j - 1 >= 0) {
                        left[i][j] += left[i][j-1];
                    }
                }

            }
        }
        //遍历每一个空地找到最大值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    t= up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    if (t > ans) {
                        ans = t;
                    }
                }
            }
        }
        return ans;
    }
}
