package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class Num13_2BFS {
    public static void main(String[] args) {
        System.out.println(movingCount(3, 1, 0));

    }
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                int[] arr = queue.poll();
                int i = arr[0];
                int j = arr[1];
                if (i >= m || j >= n || visited[i][j] || digitSum(i, j) > k) {
                    continue;
                }
                visited[i][j] = true;
                count++;
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i, j + 1});
            }
        }
        return count;
    }

    private static int digitSum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
