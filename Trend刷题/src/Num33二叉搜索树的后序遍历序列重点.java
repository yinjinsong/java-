public class Num33二叉搜索树的后序遍历序列重点 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) return true;
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int i = left, mid = 0;
        while (postorder[i] < postorder[right]) i++;
        mid = i;
        while (postorder[i] > postorder[right]) i++;
        return i == right && dfs(postorder, left, mid - 1) && dfs(postorder, mid, right - 1);
    }
}
