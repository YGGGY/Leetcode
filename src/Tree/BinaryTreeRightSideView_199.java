package Tree;
import java.util.*;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null)    return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                TreeNode curr = queue.poll();
                if(i == length - 1)
                    output.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return output;
    }
}
//用102.Binary Tree Level Order Traversal那题的思想，BFS做
//区别是102把每层都作为一个list输出，但是这题只要每层的最后一个