package Tree;
import java.util.*;

public class SymmetricTree_101 {
    //---------------------------
    //recursion
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null)
            return true;
        else if(r1 == null || r2 == null)
            return false;
        else if(r1.val != r2.val)
            return false;
        else
            return check(r1.left, r2.right) && check(r1.right, r2.left);
    }

    //-----------------------------
    //iteration
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode p1 = queue.poll();
            TreeNode p2 = queue.poll();
            if(p1 == null && p2 ==null)
                continue;
            else if(p1 == null || p2 == null)
                return false;
            else if(p1.val != p2.val)
                return false;

            queue.add(p1.left);//queue可以加入null
            queue.add(p2.right);
            queue.add(p1.right);
            queue.add(p2.left);
        }
        return true;
    }
}
