public class Num49丑数重要 {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int m = 1; m < n; m++) {
            int t = Math.min(arr[i] * 2, Math.min(arr[j] * 3, arr[k] * 5));
            arr[m] = t;
            if (arr[i] * 2 == t) i++;
            if (arr[j] * 3 == t) i++;
            if (arr[k] * 5 == t) k++;
        }
        return arr[n - 1];
    }
}
