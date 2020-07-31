package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;

public class Num57II和为s的连续正数序列 {
    public static void main(String[] args) {
        findContinuousSequence2(9);
    }
   //暴力法
    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> results = new ArrayList<>();
        int mid = target / 2 + 1;
        while (mid >= 1) {
            int sum = 0;
            for (int i = mid; i > 0; i--) {
                sum += i;
                if (sum == target) {
                    int[] arr = new int[mid - i + 1];
                    for (int j = i; j <= mid; j++) {
                        arr[j - i] = j;
                    }
                    results.add(arr);
                } else if (sum > target) {
                    break;
                }
            }
            mid--;
        }
        Collections.reverse(results);
        return results.toArray(new int[results.size()][]);
    }

    //滑动窗口
    public static int[][] findContinuousSequence2(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        ArrayList<int[]> results = new ArrayList<>();
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum == target) {
                int[] arr = new int[right - left ];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                results.add(arr);
                sum -= left;
                left++;
            } else {
                sum -= left;
                left++;
            }
        }
        return results.toArray(new int[results.size()][]);
    }

}
