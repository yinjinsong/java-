package 剑指offer;

import java.util.Arrays;

public class Num40最小的k个数快速选择解法 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[]{};
        return helper(arr, 0, arr.length - 1, k - 1);
    }

    public int[] helper(int[] arr, int left, int right, int k) {
        int index = partition(arr, left, right);
        if (index == k) return Arrays.copyOf(arr, index + 1);
        return index > k ? helper(arr, left, index - 1, k) : helper(arr, index + 1, right, k);
    }

    public int partition(int[] arr, int left, int right) {
        if (left > right) {
            return left;
        }
        int i = left;
        int j = right;
        int temp = 0;
        int base = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        return i;
    }
}
