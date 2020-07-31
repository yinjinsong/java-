import java.util.*;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                String s = scanner.next();
                if (s.contains("PUSH")) {
                    int num = scanner.nextInt();
                    queue.offer(num);
                } else if (s.contains("TOP")) {
                    if (queue.isEmpty()) {
                        list.add(-1);
                    } else {
                        list.add(queue.peek());
                    }
                } else if (s.contains("POP")) {
                    if (queue.isEmpty()) {
                        list.add(-1);
                    } else {
                        queue.poll();
                    }
                } else if (s.contains("SIZE")) {
                    list.add(queue.size());
                } else if (s.contains("CLEAR")) {
                    queue.clear();
                }
            }
            lists.add(list);
        }
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }
}


