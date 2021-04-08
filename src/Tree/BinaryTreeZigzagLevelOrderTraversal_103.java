package Tree;
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)    return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null)   queue.offer(curr.left);
                if(curr.right != null)  queue.offer(curr.right);
                if(leftToRight)
                    temp.add(curr.val);
                else
                    temp.add(0, curr.val);
            }
            output.add(temp);
            leftToRight = leftToRight? false : true;
        }
        return output;
    }
}
