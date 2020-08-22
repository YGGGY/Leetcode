package Tree;
import java.util.*;

public class PopulatingNextRightPointersInEachNode_116 {
    //和102.Binary Tree Level Order Traversal思想类似
    public Node connect(Node root) {
        if(root == null)    return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //int level = 0;
        //int size= 1;

        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i < length; i++){
                Node curr = queue.poll();
                if(i == length-1)
                    curr.next = null;
                else{
                    Node curr2 = queue.peek();
                    curr.next = curr2;
                }

                if(curr.left != null)   queue.add(curr.left);
                if(curr.right != null)  queue.add(curr.right);
            }

        }
        return root;
    }
    //Time: O(n)
    //Space: O(n)

    //--------------------------------------------
    //利用next这个pointer，遍历该层的时候，处理好下一level的node的next pointer
    //如果一个点有left，它一定有right，让left.next = right，right的next指向这个点的next点的left
    //遍历这层的时候，把下一层的Left, right节点的next处理好
    //将这层遍历完以后，走下一层的第一个点，所以要临时保存下下一层的第一个点
    public Node connect2(Node root) {
        if(root == null)    return root;

        Node temp = root;//每层第一个node

        while(temp.left != null){//有下一层
            Node curr = temp;
            while(curr != null){
                curr.left.next = curr.right;//左节点指向右节点
                if(curr.next != null)//如果curr有下一个点，让右节点指向下一个点的左节点；如果没有，右节点指向null（默认）
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            temp = temp.left;//temp改成下一层的第一个
        }
        return root;
    }

    //Time: O(n)
    //Space: O(1)
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};