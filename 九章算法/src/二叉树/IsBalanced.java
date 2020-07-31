package 二叉树;

public class IsBalanced {
    public static void main(String[] args) {

    }
    public static boolean isBalanced(TreeNode1 root) {
        return helper(root).isBalanced;
    }

    public static ResultType helper(TreeNode1 root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        //分
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //治
        //如果左子树或者右子树不是平衡树
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        //如果左子树和右子树都是平衡树则需要判断左右子树高度差是否大于1
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth));
    }
}

class ResultType{
    public boolean isBalanced;
    public int maxDepth;

    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

