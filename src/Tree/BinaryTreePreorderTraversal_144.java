package Tree;
import java.util.*;

public class BinaryTreePreorderTraversal_144 {
    //--------------------------------------
    //recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null)    return output;
        preorder(root, output);
        return output;
    }

    private void preorder(TreeNode root, List<Integer> output){
        if(root == null)
            return;

        output.add(root.val);
        preorder(root.left, output);
        preorder(root.right, output);
    }
    //Time: O(n)
    //Space: worst case O(n)


    //--------------------------------------
    //iteration
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null) return output;
        Deque<TreeNode> stack = new ArrayDeque();
        stack.push(root);

        while(!stack.isEmpty()){
            root = stack.pop();
            output.add(root.val);
            if(root.right != null)  stack.push(root.right);
            if(root.left != null)   stack.push(root.left);
        }
        return output;
    }
    //Time: O(n)
    //Space: O(n)


}
