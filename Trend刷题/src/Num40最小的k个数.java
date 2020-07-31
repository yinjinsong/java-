import java.util.PriorityQueue;
import java.util.Queue;

public class Num40最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int i : arr) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            ans[index++] = queue.poll();
        }
        return ans;
    }


}
