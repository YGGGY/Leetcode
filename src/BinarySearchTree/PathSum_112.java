package BinarySearchTree;
import java.util.*;

public class PathSum_112 {
    //iteration
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)  return false;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node; //current node
        int curr_sum; //current remainder
        while(!node_stack.isEmpty()){
            //get and pop current node
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();

            //check if is leaf and correct sum
            if((node.right == null) && (node.left == null) && (curr_sum == 0))
                return true;

            //have right subtree, push right node
            if(node.right != null){
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }

            //have left subtree, push left node
            if(node.left != null){
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }


    //recursion
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null)    return false;

        sum -= root.val;
        if((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }