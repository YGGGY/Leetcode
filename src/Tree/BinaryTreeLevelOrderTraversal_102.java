package Tree;
import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {
    //---------------------------------------
    //recursion
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)    return output;

        bfs(output, root, 0);
        return output;
    }

    private void bfs(List<List<Integer>> output, TreeNode root, int level){
        if(level == output.size())//这层list还没创建
            output.add(new ArrayList<Integer>());

        output.get(level).add(root.val);//加入该层的list里

        if(root.left != null)
            bfs(output, root.left, level+1);
        if(root.right != null)
            bfs(output, root.right, level+1);
    }

    //---------------------------------------
    //iteration

}
