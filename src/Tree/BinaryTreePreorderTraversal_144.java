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

    //--------------------------------------
    //Morris Preorder Traversal
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while(curr != null){
            if(curr.left == null){
                output.add(curr.val);
                curr = curr.right;
            }
            else{
                //把current放到current的左子树的最右node的右子树上
                pre = curr.left;//current的左子树
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }//pre变成current的左子树的最右node

                if(pre.right == null){
                    output.add(curr.val);
                    pre.right = curr;//把current放到pre的右子树上
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return output;
    }

    //Time: O(n)
    //Space: O(1)
}
