package 剑指offer;

public class Num49丑数 {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int m = 1; m < n; m++) {
            int t = Math.min(arr[i] * 2, Math.min(arr[j] * 3, arr[k] * 5));
            arr[m] = t;
            if (t == arr[i] * 2) i++;
            if (t == arr[j] * 3) j++;
            if (t == arr[k] * 5) k++;
        }
        return arr[n - 1];
    }
}
