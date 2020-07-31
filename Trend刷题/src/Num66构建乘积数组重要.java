import java.util.Arrays;

public class Num66构建乘积数组重要 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));
    }
    public static int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0, res = 1; i < a.length; i++) {
            ans[i] = res;
            res *= a[i];
        }
        for (int i = a.length - 1, res = 1; i >= 0; i--) {
            ans[i] *= res;
            res *= a[i];
        }
        return ans;
    }
}
