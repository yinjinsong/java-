package 二分法;

/*
Example
样例 1:

输入: array =[1,2,7,8,5] queries =[1,8,5]
输出:[0,4,2]
样例 2:

输入: array =[3,4,5,8] queries =[2,4]
输出:[0,1]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumber {
    public static void main(String[] args) {
        countOfSmallerNumber(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4});
    }
    //数组排序后需要找到最后一个小于target的数
    public static List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null || A.length == 0 ) {
            for (int i = 0; i < queries.length; i++) {
                list.add(0);
            }
            return list;
        }
        Arrays.sort(A);

        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = A.length - 1;
            int target = queries[i];
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (A[mid] >= target) {
                    right = mid;
                } else {
                    left = mid;
                }

            }
            if (A[right] < target) {
                list.add(right + 1);
            } else if (A[left] < target) {
                list.add(left + 1);
            } else {
                list.add(0);
            }
        }
        return list;
    }
}
