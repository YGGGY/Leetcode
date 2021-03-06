package Tree;
import java.util.*;

public class AverageOfLevelsInBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList<>();
        if(root == null)    return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            double avg = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                sum += temp.val;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            avg = (double)sum/size;
            output.add(avg);
        }

        return output;
    }
}
