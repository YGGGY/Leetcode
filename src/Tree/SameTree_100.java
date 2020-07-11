package Tree;
import java.util.*;

public class SameTree_100 {
    //----------------------------------
    //recursion
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        else if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    //----------------------------------
    //iteration
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode p1 = queue.poll();
            TreeNode p2 = queue.poll();
            if(p1 == null && p2 ==null)
                continue;
            else if(p1 == null || p2 == null)
                return false;
            else if(p1.val != p2.val)
                return false;

            queue.add(p1.left);
            queue.add(p2.left);
            queue.add(p1.right);
            queue.add(p2.right);
        }
        return true;
    }


}
