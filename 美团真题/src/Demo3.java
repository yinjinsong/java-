import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = String.valueOf(arr[i]) + "," + String.valueOf(arr[j]);
                list.add(s);
            }
        }
        Collections.sort(list);
        String ans = list.get(k - 1);
        String[] split = ans.split(",");
        System.out.println("(" + split[0] + "," + split[1] + ")" );
    }
}
