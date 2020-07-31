package 二分法;
/*
给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。
如果没有，返回到它将会被按顺序插入的位置。
你可以假设在数组中无重复元素。

Example
[1,3,5,6]，5 → 2

[1,3,5,6]，2 → 1

[1,3,5,6]， 7 → 4

[1,3,5,6]，0 → 0

Challenge
时间复杂度为O(log(n))
 */
public class SearchInsert {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{-1, 0, 1, 2}, 2));
    }
    public static int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //等价于找到第一个大于等于target的数
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target <= A[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[left] >= target) {
            return left;
        } else if (A[right] >= target) {
            return right;
        } else {
            return A.length;
        }

    }
}
