package Tree;
import java.util.*;

public class FindLeavesOfBinaryTree_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        height(root, output);
        return output;
    }

    //height是一个点到最深点有多少个edge，即叶子节点height为0，上一层height为1
    private int height(TreeNode curr, List<List<Integer>> output){
        if(curr == null)    return -1;//叶子节点的下一层height为-1

        //level是左右节点的最大height + 1，同一层level的节点放到一个output的同一个list里
        int level = 1 + Math.max(height(curr.left, output), height(curr.right, output));

        if(output.size() < level+1)//这层level的list还没创建
            output.add(new ArrayList<>());
        output.get(level).add(curr.val);
        return level;
    }
}
//计算每个点的level，根据level加入output的第几个list里
//每个点的level是左右节点的最大height + 1
//叶子节点height为0