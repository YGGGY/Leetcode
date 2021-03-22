package BinarySearchTree;
import java.util.*;

public class ValidateBinarySearchTree_098 {
    //---------------------------------
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode root, Integer lower, Integer upper){//传null只能传给Integer，不能传给int
        if(root == null)
            return true;

        if(lower != null && root.val <= lower)   return false;
        if(upper != null && root.val >= upper)   return false;

        //left:继承lower，更新upper                   right:继承upper，更新lower
        return check(root.left, lower, root.val) && check(root.right, root.val, upper);
    }

    //Time: O(n)
    //Space: O(n)

    //----------------------------------
    //iteration
    //inorder遍历BST的时候，正好是按从小到大的顺序
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        double max = -Double.MAX_VALUE;

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.val <= max)
                return false;
            max = root.val;
            root = root.right;
        }
        return true;
    }
    //Time: O(n)
    //Space: O(n)

}
