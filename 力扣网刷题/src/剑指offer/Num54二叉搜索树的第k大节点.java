package 剑指offer;

import java.util.ArrayList;

public class Num54二叉搜索树的第k大节点 {
    private ArrayList<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        inorder(root);
        return list.get(list.size() - k);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right);
        }
    }


}
