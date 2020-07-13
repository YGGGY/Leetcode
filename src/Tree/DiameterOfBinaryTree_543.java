package Tree;

public class DiameterOfBinaryTree_543 {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        result = Math.max(result, left + right);//最长的路径就是某个点的左右深度之和
        return Math.max(left, right) + 1;//对每个点，计算左右子树最深的深度
    }
}
