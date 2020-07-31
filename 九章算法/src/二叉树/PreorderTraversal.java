package 二叉树;
/*
给出一棵二叉树，返回其节点值的前序遍历。

样例
样例 1:

输入：{1,2,3}
输出：[1,2,3]
解释：
   1
  / \
 2   3
它将被序列化为{1,2,3}
前序遍历
样例 2:

输入：{1,#,2,3}
输出：[1,2,3]
解释：
1
 \
  2
 /
3
它将被序列化为{1,#,2,3}
前序遍历
挑战
你能使用非递归实现么？
 */
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        root.right = new TreeNode1(3);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(7);

        List<Integer> list = preorderTraversal(root);
        System.out.println(list);
    }

    //traverse方法
//    public List<Integer> preorderTraversal(TreeNode1 root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        traverseHelper(root, list);
//        return list;
//    }

    public static void traverseHelper(TreeNode1 root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traverseHelper(root.left, list);
        traverseHelper(root.right, list);
    }


    //分治方法
    public static List<Integer> preorderTraversal(TreeNode1 root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);

        return list;
    }

    //非递归方法

}

class TreeNode1 {
    public int val;
    public TreeNode1 left, right;

    public TreeNode1(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
