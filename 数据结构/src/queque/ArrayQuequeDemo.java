package queque;

public class ArrayQuequeDemo {

}

class ArrayQueue {
    //最大容量
    private int maxSize;
    //队头
    private int front;
    //队尾
    private int rear;
    //数组用于存放数据，模拟队列
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1 ? true : false;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front ? true : false;
    }

    //添加数据到队列
    public void add(int target) {
        if (this.isFull()) {
            System.out.println("队列已满！无法加入数据！");
            return;
        }
        rear++;
        arr[rear] = target;
    }
    //获取数据，出队列
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！无法取数据！");
        }
        front++;
        return arr[front];
    }

}