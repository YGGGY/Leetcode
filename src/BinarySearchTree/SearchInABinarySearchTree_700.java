package BinarySearchTree;

public class SearchInABinarySearchTree_700 {
    //--------------------------
    //Recursion
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)    return root;

        if(val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
    //Time: O(H) in the worst case, where H is the tree height.
    //      O(logN) in the average case
    //Space: O(H) in the worst case, where H is the tree height.
    //      O(logN) in the average case

    //--------------------------
    //Iteration
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null && root.val != val){
            if(val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }
    //Time: O(H) in the worst case, where H is the tree height.
    //      O(logN) in the average case
    //Space: O(1)
}
