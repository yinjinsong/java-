import java.util.PriorityQueue;
import java.util.Queue;

public class Num41数据流中的中位数重要 {
    Queue<Integer> smallHeap;
    Queue<Integer> bigHeap;

    public Num41数据流中的中位数重要() {
        smallHeap = new PriorityQueue<>();
        bigHeap = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        bigHeap.add(num);
        if (!smallHeap.isEmpty() && bigHeap.peek() > smallHeap.peek()) {
            int n1 = smallHeap.poll();
            int n2 = bigHeap.poll();
            smallHeap.offer(n2);
            bigHeap.offer(n1);
        }
        if (bigHeap.size() > smallHeap.size() + 1) {
            smallHeap.offer(bigHeap.poll());
        }
    }

    public double findMedian() {
        if ((bigHeap.size() + smallHeap.size()) % 2 == 1) {
            return bigHeap.peek();
        } else {
            return (bigHeap.peek() + smallHeap.peek()) / 2.0;
        }
    }
}
