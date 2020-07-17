package Tree;

public class LowestCommonAncestorOfABinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)//base case
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)    return right;//p, q其中一个在一边的子树上/p，q都不在子树上
        if(right == null)   return left;
        return root;//left != null && right != null, 说明p，q在左右子树上
    }
}
//root开始从上往下找，找到p/q返回p/q在的子树
//p、q都出现在一个点的左右子树中时，这个点是lca，且继续往上return的时候，正好return的就是这个root
//如果p、q出现在一个点的同一左/子树,说明走的不够深，继续往下走