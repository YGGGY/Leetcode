package DFSnBFS;
import javafx.util.Pair;

import java.util.*;

public class SumRootToLeafNumbers_129 {
    //---------------------------------------------------
    //DFS preorder recursion

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return sum;
    }

    private void preorder(TreeNode root, int curr){
        if(root == null)//base case
            return;
        curr = curr * 10 + root.val;
        if(root.left == null && root.right == null)//到leaf了
            sum += curr;//把这个数加进去
        preorder(root.left, curr);
        preorder(root.right, curr);
    }

    //Time: O(n) where n is the number of nodes
    //Space: O(H) where H is the height of the tree

    //-------------------------------------------------
    //iteration

    public int sumNumbers2(TreeNode root) {
        int sum = 0, curr = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));//把root push进stack里

        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();//取出并删除stack的第一个数
            root = pair.getKey();//目前的node
            curr = pair.getValue();//以前的数

            if(root != null){
                curr = curr * 10 + root.val;//以前的数进一位，加上新的数
                if(root.left == null && root.right == null)//leaf
                    sum += curr;
                else{
                    //要先往左走，因为stack的性质，所以要先push右边再push左边
                    stack.push(new Pair(root.right, curr));
                    stack.push(new Pair(root.left,curr));
                }
            }

        }
        return sum;

    }

    //Time: O(n) where n is the number of nodes
    //Space: O(H) where H is the height of the tree

    //------------------------------------------------
    //Morris preorder traversal
    public int sumNumbers3(TreeNode root) {
        int sum = 0, curr = 0;
        int step = 0;
        TreeNode pre;

        while(root != null){
            //if there is a left child, compute the predecessor
            if(root.left != null){
                //pre:先往左，然后尽量往右
                pre = root.left;
                step = 1;
                while(pre.right != null && pre.right != root){
                    pre = pre.right;
                    step++;
                }

                //没有pre.right == root的link的话
                if(pre.right == null){
                    curr = curr * 10 + root.val;
                    pre.right = root;//set link
                    root = root.left;//走Left subtree
                }
                //pre.right != null, 即:有pre.right == root这个link
                else{
                    if(pre.left == null)//走到leaf了
                        sum += curr;    //把最后的结果加到sum里

                    for(int i = 0; i < step; i++)
                        curr /= 10;
                    pre.right = null;
                    root = root.right;//走right subtree
                }
            }
            else{
                curr = curr * 10 + root.val;
                if(root.right == null)//root.left == null && root.right == null, root是leaf节点
                    sum += curr;
                root = root.right;
            }

        }
        return sum;
    }


    //Time: O(n)
    //Space: O(1) 这个方法的好处就是不需要额外的空间

    //Morris preorder traversal做法：
    //对目前的root来说，找predecessor（predecessor是root先往左走，然后尽量往右走，得到的点）
    //看有没有pre.right == root这个link
    //- 没有的话，set这个link，并且往左子树走
    //- 有的话，往右子树走。如果pre是leaf的话，把结果加到sum上，回到root上
    //
}











public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}