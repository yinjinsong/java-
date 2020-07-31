public class Num722每日一题 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return 0;
        int left = 0, right = numbers.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int target = numbers[right];
            if (numbers[mid] < target) right = mid;
            else if (numbers[mid] == target) right--;
            else left = mid;
        }
        return Math.min(numbers[left], numbers[right]);
    }
}
