package Tree;
import java.util.*;

public class DeepestLeavesSum_1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)    return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()){
            sum = 0;
            int length = queue.size();
            for(int i = 0; i < length; i++){
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return sum;
    }
}
//bfs把每层的level的sum求出来 return最后那层的sum


