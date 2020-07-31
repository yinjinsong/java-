package 力扣刷题;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class Num704 {
    public  void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int len=nums.length;
        if (len == 0) {
            return -1;
        }
        int left=0;
        int right=len-1;
        while (left < right) {
            int mid=(left+right)>>>1;
            if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right=mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
