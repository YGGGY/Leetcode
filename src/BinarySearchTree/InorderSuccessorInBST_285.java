package BinarySearchTree;

public class InorderSuccessorInBST_285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root;
        TreeNode candidate = null;

        while(curr != null){
            if(p.val >= curr.val)
                curr = curr.right;
            else{
                candidate = curr;
                curr = curr.left;
            }
        }
        return candidate;
    }
}
