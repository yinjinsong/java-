package 力扣刷题;

public class Num287寻找重复数 {
    public int findDuplicate(int[] nums) {
        //枚举每个数
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num >= left && num <= mid) cnt++;
            }
            if (cnt > mid - left + 1) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
