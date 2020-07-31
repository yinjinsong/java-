package 剑指offer;

public class Num33二叉搜索树的后序遍历序列 {
    //递归重建找出左右区间分别判断
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int temp = left;
        while (postorder[temp] < postorder[right]) {
            temp++;
        }
        int m = temp;
        while (postorder[temp] > postorder[right]) {
            temp++;
        }
        return temp == right && helper(postorder, left, m - 1) && helper(postorder, m, right - 1);
    }
}
