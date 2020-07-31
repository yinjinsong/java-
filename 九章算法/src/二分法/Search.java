package 二分法;
/*
输入: [4, 5, 1, 2, 3] and target=1,
输出: 2.
例2:

输入: [4, 5, 1, 2, 3] and target=0,
输出: -1.
Challenge
O(logN) 时间限制
 */
public class Search {
    public static void main(String[] args) {

    }
    //o(n)
//    public static int search(int[] A, int target) {
//        if (A == null || A.length == 0) {
//            return -1;
//        }
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }
    //o(log(n))
    public static int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        //A是连续两段递增的序列，我们只需要判断target在递增的序列上用二分查找，
        //将复杂的情况归为else,if用来判定简单的情况
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            //如果mid在第一段单调递增的序列
            if (A[left] < A[mid]) {
                //如果target在序列中
                if (target >= A[left] && target <= A[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                //如果target在第2段单调递增的序列
                if (target >= A[mid] && target <= A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (A[left] == target) {
            return left;
        } else if (A[right] == target) {
            return right;
        } else {
            return -1;
        }


    }
}
