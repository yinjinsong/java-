import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num0401节点间通路 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] map = new ArrayList[n];
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (map[from] == null) {
                map[from] = new ArrayList<>();
            }
            map[from].add(to);
        }
        return bfs(n, map, start, target);
    }

    private boolean bfs(int n, List<Integer>[] map, int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                List<Integer> list = map[poll];
                if (list == null) continue;
                for (Integer integer : list) {
                    if (visited[integer]) continue;
                    if (integer == target) return true;
                    visited[integer] = true;
                    queue.offer(integer);
                }
            }
        }
        return false;
    }
}
