import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Demo44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CQueue queue = new CQueue();
        ArrayList<Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (s.contains("add")) {
                int num = scanner.nextInt();
                queue.add(num);
            } else if (s.contains("peek")) {
                //System.out.println(queue.peek());
                list.add(queue.peek());
            } else if (s.contains("poll")) {
                queue.poll();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    //stack1用来压栈、stack2用来pop
    public void add(int value) {
        stack1.push(value);
    }

    public int poll() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }

        }
    }
}