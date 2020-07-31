package 剑指offer;


import java.util.HashMap;

public class Num07重建二叉树 {
    private int[] preOrder;
    private HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        //存储中序遍历的位置
        this.preOrder = preorder;
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(0, preorder.length - 1, 0, inorder.length - 1);
    }


    private TreeNode buildTreeHelper(int preLeft, int preRight, int inLeft, int inRight) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        //当前根节点的值,前序第一个
        int rootValue = preOrder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        //查找index
        Integer rootIndex = indexMap.get(rootValue);
        //中序数组中划分出左子树和右子树的长度
        int leftLen = rootIndex - inLeft;
        int rightLen = inRight - rootIndex;
        //确定好长度就可以在前序数组中递归找左子树和右子树
        TreeNode left = buildTreeHelper(preLeft + 1, preLeft + leftLen, inLeft, rootIndex - 1);
        TreeNode right = buildTreeHelper(preLeft + leftLen + 1, preRight, rootIndex + 1, inRight);
        root.left = left;
        root.right = right;
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}