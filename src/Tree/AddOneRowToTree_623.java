package Tree;

public class AddOneRowToTree_623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if(d > 2){
            for(int i = 2; i < d; i++){
                int size = queue.size();
                for(int j = 0; j < size; j++){
                    TreeNode temp = queue.poll();
                    if(temp.left != null) queue.add(temp.left);
                    if(temp.right != null) queue.add(temp.right);
                }
            }
        }

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            TreeNode left = new TreeNode(-1);
            TreeNode right = new TreeNode(-1);
            if(temp.left != null){
                left = temp.left;
                temp.left = new TreeNode(v);
                temp.left.left = left;
            }
            else
                temp.left = new TreeNode(v);
            if(temp.right != null){
                right = temp.right;
                temp.right = new TreeNode(v);
                temp.right.right = right;
            }
            else
                temp.right = new TreeNode(v);
        }
        return root;
    }
}

//做法和traverse level一个做法 但是细节处理很多