import java.util.Arrays;

public class Num1709第K个数 {
    public int getKthMagicNumber(int k) {
        int[] arr = new int[k];
        arr[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < k; i++) {
            int t = Math.min(arr[p1] * 3, Math.min(arr[p2] * 5, arr[p3] * 7));
            arr[i] = t;
            if (arr[p1] * 3 == t) p1++;
            if (arr[p2] * 5 == t) p2++;
            if (arr[p3] * 7 == t) p3++;
        }
        System.out.println(Arrays.toString(arr));
        return arr[k - 1];
    }
}
