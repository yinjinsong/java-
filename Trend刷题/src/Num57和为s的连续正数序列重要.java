import java.util.ArrayList;
import java.util.List;

public class Num57和为s的连续正数序列重要 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int left = 1, right = 1, sum = 0;
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum == target) {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                ans.add(arr);
                sum -= left;
                left++;
            } else {
                sum -= left;
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
