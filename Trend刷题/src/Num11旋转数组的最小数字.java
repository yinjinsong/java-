public class Num11旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        //可以有重复
        int left = 0, right = numbers.length - 1, edge;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            edge = numbers[right];
            //找到第一个小于最右边的数
            if(numbers[mid]<edge) right = mid;
            else if(numbers[mid]==edge) right--;
            else left = mid;
        }
        return Math.min(numbers[left], numbers[right]);
    }
}
