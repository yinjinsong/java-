public class Num167两数之和2输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) left++;
            else if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            else right--;
        }
        return new int[0];
    }
}
