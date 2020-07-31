package 剑指offer;

import java.util.Arrays;

public class Num21调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] exchange = exchange2(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(exchange));

    }
    //方法一，开辟数组
    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] arr = new int[nums.length];
        int oddPoint = 0;
        int evenPonit = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                arr[oddPoint] = nums[i];
                oddPoint++;
            } else {
                arr[evenPonit] = nums[i];
                evenPonit--;
            }

        }
        return arr;
    }
    //方法二，原地交换
    public static int[] exchange2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

        }
        return nums;
    }
}
