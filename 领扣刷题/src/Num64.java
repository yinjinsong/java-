/*
样例 2:

输入：[1,2,5] 3 [3,4] 2
输出：[1,2,3,4,5]
解释：
经过合并新的数组为[1,2,3,4,5]
注意事项
你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 */
public class Num64 {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {

       //从就往前比较直接在A的后面开始添加
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (A[p1] <= B[p2]) {
                A[p3--] = B[p2--];
            } else {
                A[p3--] = A[p1--];
            }
        }
        //把剩下的添加进去
        while (p1 >= 0) {
            A[p3--] = A[p1--];
        }
        while (p2 >= 0) {
            A[p3--] = B[p2--];
        }

    }
}
