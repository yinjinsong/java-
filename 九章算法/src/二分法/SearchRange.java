package 二分法;

/*
给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。

如果目标值不在数组中，则返回[-1, -1]

Example
例1:

输入:
[]
9
输出:
[-1,-1]

例2:

输入:
[5, 7, 7, 8, 8, 10]
8
输出:
[3, 4]
Challenge
时间复杂度 O(log n)
 */
public class SearchRange {
    public static void main(String[] args) {

    }
    public static int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        //找到第一个小于等于target的元素
        int left = 0;
        int right = A.length - 1;
        int[] ans = new int[2];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] == target) {
            ans[0] = left;
        } else if (A[right] == target) {
            ans[0] = right;
        } else {
            return new int[]{-1, -1};
        }

        //找到最后一个等于target的元素
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[right] == target) {
            ans[1] = right;
        }else {
            ans[1] = left;
        }
        return ans;
    }
}
