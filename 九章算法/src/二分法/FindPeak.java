package 二分法;

/*
你给出一个整数数组(size为n)，其具有以下特点：

相邻位置的数字是不同的
A[0] < A[1] 并且 A[n - 2] > A[n - 1]
假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
Example
样例 1:
	输入:  [1, 2, 1, 3, 4, 5, 7, 6]
	输出:  1 or 6

	解释:
	返回峰顶元素的下标


样例 2:
	输入: [1,2,3,4,1]
	输出:  3
Notice
数组保证至少存在一个峰
如果数组存在多个峰，返回其中任意一个就行
数组至少包含 3 个数
 */
public class FindPeak {
    public static void main(String[] args) {

    }
    public static int findPeak(int[] A) {
        int left = 1;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            //在递增线段上
            if (A[mid] > A[mid - 1]) {
                left = mid;
            }
//            else if (A[mid] > A[mid + 1]) {
//                right = mid;
//            } else {
//                right = mid;
//            }
            else {
                right = mid;
            }
        }
        if (A[left] < A[right]) {
            return right;
        } else {
            return left;
        }
    }
}
