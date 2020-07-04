package Tree;
import java.util.*;

public class BinaryTreeInorderTraversal_094 {
    //-----------------------------------
    //recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        inorder(root, output);
        return output;
    }

    private void inorder(TreeNode root, List<Integer> output){
        if(root == null)
            return;

        inorder(root.left, output);
        output.add(root.val);
        inorder(root.right, output);
    }

    //Time: O(n)
    //Space: worst case O(n)

    //----------------------------------------
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null) return output;

        Deque<TreeNode> stack = new ArrayDeque();
        while(root != null || !stack.isEmpty()){
            //找出该node最左的子孙节点
            while(root != null){
                stack.push(root);//往左途中的node全部入栈
                root = root.left;
            }

            //root==null，说明:往左走到头了，取最左的node||上一步往右走 走到null了，要往上走一层，所以pop
            root = stack.pop();//取最左的node||往上走一层
            output.add(root.val);
            root = root.right;//往右走一步
        }
        return output;
    }
    //Time: O(n)
    //Space: O(n)

}
