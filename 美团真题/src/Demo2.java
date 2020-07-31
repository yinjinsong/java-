import java.util.HashSet;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();

        while (true) {
            x = (a * x + b) % m;
            if (!set.contains(x)) {
                set.add(x);

            } else {
                break;
            }
        }

        System.out.println(set.size());
    }

}
