package Tree;
import java.util.*;

public class SubtreeOfAnotherTree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.val == t.val)
                if(check(curr,t))
                    return true;
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }

        return false;
    }

    private boolean check(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        else if(s == null || t == null)
            return false;
        else if(s.val != t.val)
            return false;

        return check(s.left, t.left) && check(s.right, t.right);
    }
}
//bfs遍历找到相同的点以后，再递归这两个tree是否相等
