package recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        getWay(1, 1, map, 4, 1);
        printMap(map);
    }

    /**
     * (i,j)代表起始位置 (end_i,end_j)代表终点
     * 需要定义找路的策略，采用1.下 2.右 3.上 4.左
     * 如果走过的路就置2 如果走不通的路就置3
     * @param i
     * @param j
     * @param map 地图
     * @param end_i
     * @param end_j
     * @return
     */
    public static boolean getWay(int i, int j, int[][] map, int end_i, int end_j) {
        if (map[end_i][end_j] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;//先假定可以走
                if (getWay(i + 1, j, map, end_i, end_j)) {
                    return true;
                } else if (getWay(i, j + 1, map, end_i, end_j)) {
                    return true;
                } else if (getWay(i - 1, j, map, end_i, end_j)) {
                    return true;
                } else if (getWay(i, j - 1, map, end_i, end_j)) {
                    return true;
                } else {
                    //如果都走不通则置为3
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果当前点不为0 则可能是 1,2,3
                return false;
            }
        }
    }

    /**
     * 打印迷宫地图
     * @param map
     */
    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
