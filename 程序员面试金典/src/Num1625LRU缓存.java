import java.util.HashMap;
import java.util.LinkedList;

public class Num1625LRU缓存 {
    private LinkedList<Integer> list;
    private HashMap<Integer, Integer> map;
    private int capacity;

    public Num1625LRU缓存(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            map.put(key, value);
            return;
        }
        if (list.size() == capacity) {
            map.remove(list.removeFirst());
        } else {
            list.remove((Integer) key);
        }
        list.addLast(key);
        map.put(key, value);
    }
}


