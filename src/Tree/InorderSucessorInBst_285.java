package Tree;

public class InorderSucessorInBst_285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root;
        TreeNode candidate = null;

        while(curr != null){
            if(p.val >= curr.val) //p>curr, 往curr右子树找；p==curr，往p的右子树找，如果p没有右子树，那就返回之前的candidate
                curr = curr.right;
            else{  //p<curr, 往curr的左子树找，但curr本身也可能是结果，先记为。如果后面还能找到>p的数，再更新candidate，
                candidate = curr;
                curr = curr.left;
            }
        }
        return candidate;
    }
}
