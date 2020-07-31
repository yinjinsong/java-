package 力扣刷题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Num210课程表II {
    public static void main(String[] args) {
        int[] order = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(Arrays.toString(order));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] ans = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0) queue.offer(i);
        }
        int pos = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ans[pos++] = poll;
            for (int[] edge : prerequisites) {
                if (edge[1] == poll) {
                    input[edge[0]]--;
                    if (input[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        if (pos != numCourses) return new int[]{};
        return ans;
    }
}
