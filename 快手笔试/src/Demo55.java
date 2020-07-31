import java.util.ArrayList;
import java.util.Scanner;

public class Demo55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int nodeIndex = scanner.nextInt();
            int k = scanner.nextInt();
            int startIndex = (int)Math.pow(2, k - 1);
            int endIndex = (int) Math.pow(2, k) - 1;

            if (nodeIndex <= endIndex) {
                list.add(-1);
            } else {
                while (nodeIndex > endIndex) {
                    nodeIndex /= 2;
                }
                list.add(nodeIndex);
            }

        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
