package 剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Num40最小的k个数大顶堆解法 {
    public static void main(String[] args) {
        int[] leastNumbers2 = getLeastNumbers(new int[]{2, 5, 7, 9, 1}, 0);
        System.out.println(Arrays.toString(leastNumbers2));

    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        Queue<Integer> bigHeap = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);
        for (int i : arr) {
            if (bigHeap.size() < k) {
                bigHeap.offer(i);
            } else if (i < bigHeap.peek()) {
                bigHeap.poll();
                bigHeap.offer(i);
            }
        }
        return bigHeap.stream().mapToInt(Integer::intValue).toArray();

    }

}



