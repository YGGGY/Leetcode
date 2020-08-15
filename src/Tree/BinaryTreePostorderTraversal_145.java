package Tree;
import java.util.*;

public class BinaryTreePostorderTraversal_145 {
    //------------------------------
    //recursion
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null)    return output;
        postorder(root, output);
        return output;
    }

    private void postorder(TreeNode root, List<Integer> output){
        if(root == null)    return;

        postorder(root.left, output);
        postorder(root.right, output);
        output.add(root.val);
    }


    //---------------------------------
    //iteration
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null)    return output;
        Deque<TreeNode> stack = new ArrayDeque();
        stack.push(root);

        while(!stack.isEmpty()){
            root = stack.pop();
            output.add(0, root.val);
            if(root.left != null)   stack.push(root.left);
            if(root.right != null)  stack.push(root.right);
        }
        return output;
    }

    //postorder比起preorder要反过来输出
    //所以是add(0, root.val)，以及先push left再push right
}
