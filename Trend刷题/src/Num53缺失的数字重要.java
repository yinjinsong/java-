public class Num53缺失的数字重要 {
    public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(left + " " + right);
            return left;
    }
}
