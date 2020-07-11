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
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        else if(p.val != q.val)
            return false;

        Deque<TreeNode> stackP = new ArrayDeque();
        Deque<TreeNode> stackQ = new ArrayDeque();
        stackP.push(p);
        stackQ.push(q);
        while(!stackP.isEmpty()){
            TreeNode currP = stackP.pop();
            TreeNode currQ = stackQ.pop();
            if(check(currP, currQ)){
                if(!check(currP.left, currQ.left))
                    return false;
                if(currP.left != null){
                    stackP.push(currP.left);
                    stackQ.push(currQ.left);
                }
                if(!check(currP.right, currQ.right))
                    return false;
                if(currP.right != null){
                    stackP.push(currP.right);
                    stackQ.push(currQ.right);
                }
            }
            else
                return false;
        }
        return true;
    }

    private boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        else if(p.val != q.val)
            return false;
        else
            return true;
    }
}
