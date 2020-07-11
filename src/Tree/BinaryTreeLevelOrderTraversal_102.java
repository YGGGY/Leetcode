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
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)    return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();//用来保存这层的点
            int length = queue.size();
            for(int i = 0; i < length; i++){//把这层的node依次取出来-加到这层的temp里-加他们的子节点到queue
                TreeNode curr = queue.remove();
                temp.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            output.add(temp);//这层遍历完了，加到output上
        }
        return output;
    }

}
