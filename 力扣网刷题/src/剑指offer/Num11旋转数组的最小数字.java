package 剑指offer;

public class Num11旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        //会用重复数字
        int left = 0;
        int right = numbers.length - 1;


        while (left + 1 < right) {
            int target = numbers[right];
            int mid = left + (right - left) / 2;
            if (numbers[mid] < target) {
                right = mid;
            } else if (numbers[mid] == target) {
                //因为数组中已经有和右边界相等的数，所以删除右边界的数也没关系
                right--;
            } else {
                left = mid;
            }
        }
        return numbers[left] < numbers[right] ? numbers[left] : numbers[right];

    }
}
