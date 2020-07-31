package 剑指offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Num41数据流中的中位数 {
    Queue<Integer>minHeap, maxHeap;
    public Num41数据流中的中位数() {
        //小根堆
        minHeap = new PriorityQueue<>();
        //大根堆
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            //交换根顶元素
            int v1 = maxHeap.poll();
            int v2 = minHeap.poll();
            minHeap.offer(v1);
            maxHeap.offer(v2);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
