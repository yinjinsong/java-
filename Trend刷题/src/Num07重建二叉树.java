import java.util.HashMap;

public class Num07重建二叉树 {
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft>preRight||inLeft>inRight) return null;
        int rootValue = preorder[preLeft];
        int rootIndex = indexMap.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int leftChildLength = rootIndex - inLeft;
        root.left = dfs(preLeft + 1, preLeft + leftChildLength, inLeft, rootIndex - 1);
        root.right = dfs(preLeft + leftChildLength + 1, preRight, rootIndex + 1, inRight);
        return root;
    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}