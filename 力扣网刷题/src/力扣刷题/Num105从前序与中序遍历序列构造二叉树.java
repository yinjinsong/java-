package 力扣刷题;

import java.util.HashMap;

public class Num105从前序与中序遍历序列构造二叉树 {
    /*
        前序序列中找根节点
        中序中找出根节点下标，区分出左右子树的长度
        递归找下去
     */
    private HashMap<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //存放中序遍历中结点值对应的下标
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        //新建根结点
        TreeNode root = new TreeNode(rootValue);
        //查找根结点在中序中的下标
        Integer rootIndex = indexMap.get(rootValue);
        //左子树长度
        int leftLen = rootIndex - inLeft;
        //递归重建左子树
        TreeNode left = helper(preorder, preLeft + 1, preLeft + leftLen, inorder, inLeft, rootIndex - 1);
        //递归重建右子树
        TreeNode right = helper(preorder, preLeft + leftLen + 1, preRight, inorder, rootIndex + 1, inRight);

        root.left = left;
        root.right = right;

        return root;
    }
}

