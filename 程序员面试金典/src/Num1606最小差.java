import java.util.Arrays;

public class Num1606最小差 {
    public static void main(String[] args) {
        smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0});
    }
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int ans = Integer.MIN_VALUE, index1 = 0, index2 = 0;
        while (index1 < a.length && index2 < b.length) {
            ans = Math.max(ans, -Math.abs(a[index1] - b[index2]));
            if (a[index1] < b[index2]) index1++;
            else index2++;
        }
        return Math.abs(ans);
    }
}
