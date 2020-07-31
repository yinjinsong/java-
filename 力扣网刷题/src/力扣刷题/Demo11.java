package 力扣刷题;

import java.util.HashMap;
import java.util.Map;

public class Demo11 {
    //定义在方法外，就不用传参，避免参数过多
    //新建一个map存储中序遍历的下标
    private  Map<Integer, Integer> indexMap;

    private int[] pre;

    /*
    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
     */
    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(0, preorder.length - 1, 0, inorder.length - 1);


    }
    //
    private  TreeNode buildTreeHelper(int preLeft,int preRight,int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        //前序遍历中的第一个结点就是root结点
        int rootValue = pre[preLeft];
        TreeNode root = new TreeNode(rootValue);
        //获取root结点在中序遍历中的index
        Integer rootIndex = indexMap.get(rootValue);

        //重建左子树
        root.left = buildTreeHelper(preLeft + 1, preLeft + rootIndex - inLeft, inLeft, rootIndex - 1);

        //重建右子树
        root.right = buildTreeHelper(preLeft + (rootIndex - inLeft) + 1, preRight, rootIndex + 1, inRight);
        return root;
    }

}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
