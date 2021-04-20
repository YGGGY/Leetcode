package Tree;
import java.util.*;

public class NaryTreePreorderTraversal_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<>();
        if(root == null)    return output;
        Deque<Node> stack = new ArrayDeque();
        stack.push(root);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            if(curr.children != null){
                output.add(curr.val);
                for(int i = curr.children.size()-1; i >= 0; i--){
                    stack.push(curr.children.get(i));
                }
            }
            else{
                output.add(curr.val);
            }
        }
        return output;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
