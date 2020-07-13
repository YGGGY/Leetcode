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
        result = Math.max(result, left + right);//最长的路径就是某个点的左右高度之和
        return Math.max(left, right) + 1;//对每个点，取左右子树最高的高度 + 1
    }
}
//通过计算每个点的路径长得到最打路径长。
//每个点的路径长是左右子树height之和
//每个点的height为左右节点的最大height + 1，叶子节点height为1