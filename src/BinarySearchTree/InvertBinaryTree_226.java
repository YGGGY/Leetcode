package BinarySearchTree;
import java.util.*;

public class InvertBinaryTree_226 {
    //recursion
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
    //Since each node in the tree is visited only once, the time complexity is O(n)O(n), where n is the number of nodes in the tree.
    //O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree. The space complexity is O(n).

    //-----------------------------
    //iterative
    public TreeNode invertTree2(TreeNode root) {
        if(root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            //swap
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return root;
    }








    //We need to swap the left and right child of all nodes in the tree
    //So we create a queue to store the nodes whose left and right child have not been swapped yet
    //Initially, only the root is in the queue
    //As long as the queue is not empty, remove the next node from the queue and swap its children and add the children to the queue
}
