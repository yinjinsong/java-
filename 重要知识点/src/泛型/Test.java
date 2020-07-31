package 泛型;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Class<? extends ArrayList> c1 = new ArrayList<String>().getClass();
        Class<? extends ArrayList> c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);//true
    }
}

// SimpleHolder.java
 class SimpleHolder {
    private Object obj;
    public void set(Object obj) { this.obj = obj; }
    public Object get() { return obj; }
    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String string = (String)holder.get();
    }
}

// GenericHolder.java
 class GenericHolder<T> {
    private T obj;
    public void set(T obj) { this.obj = obj; }
    public T get() { return obj; }
    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<>();
        holder.set("Item");
        String s = holder.get();
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.stream().mapToInt(Integer::intValue).toArray();
    }
}