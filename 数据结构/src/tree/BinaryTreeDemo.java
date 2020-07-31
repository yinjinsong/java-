package tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        //前序遍历二叉树
        //binaryTree.preOrder();

        //中序
        // binaryTree.inOrder();

        //后序
        //binaryTree.postOrder();

        //前序查找
        //HeroNode heroNode = binaryTree.preSearch(10);


        //中序查找
//        HeroNode heroNode = binaryTree.inSearch(5);
//        System.out.println(heroNode);
        System.out.println("删除前的前序遍历");
        binaryTree.preOrder();
        //删除指定节点
        HeroNode del = binaryTree.del(100);
        //被删除的节点
        System.out.println("被删除的节点");
        System.out.println(del);
        System.out.println("删除后的前序遍历");
        binaryTree.preOrder();
    }
}


class BinaryTree{
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root == null) {
            System.out.println("空树，无法遍历");

        } else {
            this.root.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (this.root == null) {
            System.out.println("空树，无法遍历");
        }else {
            this.root.inOrder();
        }

    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        if (this.root == null) {
            System.out.println("空树，无法遍历");
        } else {
            this.root.postOrder();
        }
    }

    public HeroNode preSearch(int num) {
        HeroNode resNode = null;
        if (this.root == null) {
            System.out.println("空树，无法查找");
        } else {
            resNode=this.root.preSearch(num);
        }
        return resNode;
    }

    public HeroNode inSearch(int num) {
        HeroNode resNode = null;
        if (this.root == null) {
            System.out.println("空树，无法查找");
        } else {
            resNode=this.root.inSearch(num);
        }
        return resNode;
    }

    /**
     * 删除指定节点
     * @param num
     * @return
     */
    public HeroNode del(int num) {
        HeroNode resNode = null;
        if (this.root != null) {
            if (this.root.getNo() == num) {
                resNode = this.root;
                this.root = null;
                return resNode;
            } else {
                resNode=this.root.del(num);
            }
        } else {
            System.out.println("空树，无法删除");
        }
        return resNode;
    }

}





class HeroNode {
    //数据域
    private int no;
    private String name;
    //指针域
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    /*
        前序遍历(根左右)
        1.先输出根节点的值
        2.判断左子树是否为空，如果不为空则前序遍历左子树
        3.如果左子树为空，则判断右子树是否为空，如果右子树不
        为空，则前序遍历右子树
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    /*
        中序遍历（左根右）
        1.先判断当前结点的左结点是否为空，如果不为空则对左节点进行递归中序遍历
        2.输出当前结点的值
        3.判断当前结点的右结点是否为空，如果不为空则对右结点进行中序递归遍历
     */
    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    /*
        后序遍历（左右根）
        1.先判断当前结点的左结点是否为空，如果不为空则对左节点进行递归后序遍历
        2.判断当前结点的右结点是否为空，如果不为空则对右结点进行后序递归遍历
        3.输出当前结点的值
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }

    /*
        前序查找某个结点
        1.先判断当前结点是否等于目标结点，如果等于则直接返回结点。
        2.如果不等于则递归前序查找判断左子节点（非null）
        3.如果不等于则递归前序查找判断右子节点（非null）
     */
    public HeroNode preSearch(int num) {
        HeroNode resNode = null;
        System.out.println("前序查找中...");
        if (this.no == num) {
            return this;
        }
        if (this.left != null) {
            resNode = this.left.preSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preSearch(num);
        }
        return resNode;
    }

    public HeroNode inSearch(int num) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.inSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("中序查找中...");
        if (this.no == num) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.inSearch(num);
        }
        return resNode;
    }

    /**
     * 删除指定节点就是将指定节点置位null
     * 1.二叉树是单向的，只能判断左右结点是不是等于目标值
     * 2.如果当前结点的左子节不为空且点等于目标结点的值，则置空并返回
     * 3.如果当前结点的右子节点不为空且等于目标结点的值，则置空并返回
     * 4.如果没有找到目标结点的值，则需要左子节点前序递归查找并删除
     * 5.如果没有找到目标结点的值，右子节点前序递归查找并删除
     * 根据指定id删除子节点
     * @param num
     * @return 删除的结点
     */
    public HeroNode del(int num) {
        HeroNode resNode = null;
        if (this.left != null && this.left.no == num) {
            resNode = this.left;
            this.left = null;
            return resNode;

        }
        if (this.right != null && this.right.no == num) {
            resNode = this.right;
            this.right = null;
            return resNode;
        }
        if (this.left != null) {
            resNode=this.left.del(num);
        }
        if (this.right != null) {
            resNode=this.right.del(num);
        }
        return resNode;
    }

}