package 力扣刷题;

public class Num347返回前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        helper(nums, 0, nums.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }
        return ans;
    }

    private void helper(int[] nums, int left, int right, int k) {
        int index = partition(nums, left, right);
        if (index == k) {
            return;
        } else if (index < k) {
            helper(nums, index + 1, right, k);
        } else {
            helper(nums, left, index - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        if (left > right) {
            return left;
        }
        int i = left;
        int j = right;
        int base = nums[left];
        int temp = 0;
        while (i < j) {
            while (i < j && nums[j] >= base) {
                j--;
            }
            while (i < j && nums[i] <= base) {
                i++;
            }
            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        return i;
    }
}
