package 二分法;
/*
给定一个旋转排序数组，在原地恢复其排序。（升序）

Example
Challenge
使用O(1)的额外空间和O(n)时间复杂度

Clarification
什么是旋转数组？

比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */
import java.util.ArrayList;
import java.util.List;

public class RecoverRotatedSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        recoverRotatedSortedArray(list);
    }

    public static void recoverRotatedSortedArray(List<Integer> nums) {
        //先找到最小的值
        //即找到第一个小于最后一个元素的值
        if (nums == null || nums.size() == 0) {
            return;
        }
        int minVal = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < minVal) {
                minVal = nums.get(i);
            }
        }
        int index = nums.indexOf(minVal);
        int i = 0;
        while (i < index) {
            nums.add(nums.get(0));
            nums.remove(0);
            i++;
        }
    }
}
