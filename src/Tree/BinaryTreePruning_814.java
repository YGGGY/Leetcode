package Tree;

public class BinaryTreePruning_814 {
    public TreeNode pruneTree(TreeNode root) {
        check(root);
        return root;
    }

    private boolean check(TreeNode curr){
        if(curr == null)    return false;//叶子节点的子节点设为false，叶子为0就去掉，叶子为1保留

        if(!check(curr.left))
            curr.left = null;//左子树全是0，去掉
        if(!check(curr.right))
            curr.right = null;//右子树全是0，去掉

        return curr.val == 1 || check(curr.left) || check(curr.right);
    }
}
//从下往上找，不过用recursion从上往下写