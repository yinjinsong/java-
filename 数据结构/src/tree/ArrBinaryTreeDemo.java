package tree;

public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //arrBinaryTree.preOrder();
       //arrBinaryTree.inOrder();
        arrBinaryTree.postOrder(0);

    }
}

class ArrBinaryTree {

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void inOrder() {
        this.inOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);

    }

    /**
     * 顺序存储二叉树的前序遍历
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能前序遍历二叉树");
        }
        System.out.println(arr[index]);
        //遍历当前结点的左子树
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 中序遍历顺序存储二叉树
     * @param index
     */
    public void inOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能中序遍历二叉树");
        }
        if ((index * 2 + 1) < arr.length) {
            inOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);

        if ((index * 2 + 2) < arr.length) {
            inOrder(index * 2 + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能后序遍历二叉树");
        }
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }
}
