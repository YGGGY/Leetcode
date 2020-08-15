package Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    //preStart:每次循环中的当前root在preorder的index
    //inStart, inEnd: 这个（子）树的数在inorder里的范围
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length - 1 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);//这次循环中的root
        //找root在inorder的位置
        int index = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(root.val == inorder[i])
                index = i;
        }

        root.left = helper(preStart + 1, inStart, index-1, preorder, inorder);//左子树boundary：inorder里inStart到root左边
        root.right = helper(preStart + index - inStart + 1, index+1, inEnd, preorder, inorder);
        //index-inStart是当前root的左子树的size，preorder的root-left-right，所以右子树要越过root和left

        return root;
    }
}

//preorder的第一个数a是tree的root，在inorder的a之前的数都是左子树，a之后的都是右子树
//重复这个过程，可以找到所有的左右子树