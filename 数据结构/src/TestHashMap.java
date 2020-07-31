import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(10, 0.75f);
        for (int i = 0; i < 100; i++) {
            map.put(i * 99, "lx" + i * 98);
        }
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            String value = next.getValue();
            Integer key = next.getKey();
            System.out.println(key + ":" + value);
            if (map.containsKey(key)) {
                System.out.println("有此key了");
            }
        }
    }

}
