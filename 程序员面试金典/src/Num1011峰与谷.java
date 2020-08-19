public class Num1011峰与谷 {
    public static void main(String[] args) {
        wiggleSort(new int[]{3, 5, 2, 1, 6, 4});

    }
    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            } else {
                if (nums[i] > nums[i - 1]) swap(nums, i, i - 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
