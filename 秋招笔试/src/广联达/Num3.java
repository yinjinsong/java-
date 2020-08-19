package 广联达;

import java.util.Scanner;
//两个矩形是否相交
public class Num3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rect1 = new int[4];
        int[] rect2 = new int[4];
        for (int i = 0; i < 8; i++) {
            if (i <= 3) {
                rect1[i] = scanner.nextInt();
            } else {
                rect2[i - 4] = scanner.nextInt();
            }
        }
        boolean ans = Math.min(rect1[2], rect2[2]) > Math.max(rect1[0], rect2[0]) && Math.min(rect1[3], rect2[3]) > Math.max(rect1[1], rect2[1]);
        System.out.println(ans ? 1 : 0);
    }
}
