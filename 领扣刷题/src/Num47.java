import java.util.List;
/*
给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
样例
例1:

输入: [99,2,99,2,99,3,3],
输出: 99.
例2:

输入: [1, 2, 1, 2, 1, 3, 3],
输出: 1.
挑战
要求时间复杂度为O(n)，空间复杂度为O(1)。

注意事项
数组中只有唯一的主元素
 */
public class Num47 {
    public static void main(String[] args) {

    }
    public int majorityNumber(List<Integer> nums) {
        int majorNum1 = 0;
        int majorNum2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == majorNum1) {
                count1++;
            } else if (nums.get(i) == majorNum2) {
                count2++;
            } else if (count1 == 0) {
                majorNum1 = nums.get(i);
                count1++;
            } else if (count2 == 0) {
                majorNum2 = nums.get(i);
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        //找到出现次数最多的
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == majorNum1) {
                count1++;
            }
            if (nums.get(i) == majorNum2) {
                count2++;
            }

        }
        return count1 > count2 ? majorNum1 : majorNum2;
    }


}
