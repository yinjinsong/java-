public class Num26树的子结构重点 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isPart(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isPart(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return isPart(a.left, b.left) && isPart(a.right, b.right);
    }
}

