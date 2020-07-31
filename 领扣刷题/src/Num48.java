import java.util.HashMap;
import java.util.List;
/*
给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。

样例
例1:

输入: [3,1,2,3,2,3,3,4,4,4] and k=3,
输出: 3.
例2:

输入: [1,1,2] and k=3,
输出: 1.
挑战
要求时间复杂度为O(n)，空间复杂度为O(k)
 */
public class Num48 {
    public int majorityNumber(List<Integer> nums, int k) {
        HashMap hashMap = new HashMap<Integer, Integer>();
        int majorNum = 0;
        for (Integer num : nums) {
            Integer count = (Integer) hashMap.get(num);
            if (count == null) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, count + 1);
                if (count + 1 > nums.size() / k) {
                    majorNum = num;
                    break;
                }
            }
        }
        return majorNum;
    }
}
