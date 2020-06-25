package BinarySearchTree;

public class CountCompleteTreeNodes_222 {

    //--------------------------------------------------
    //recursion的做法
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    //Time: O(n) node数
    //Space: O(logn) 树高



    //------------------------------------------------
    public int countNodes2(TreeNode root) {
        if(root == null)    return 0;

        int depth = computeDepth(root);
        if(depth == 0) return 1;

        int left = 1, right = (int)Math.pow(2, depth) - 1;//最后一层最多2^d个数，至少1个数
        int mid;
        while(left <= right){
            mid = left + (right-left)/2;
            if(exists(mid, depth, root))//mid这个点存在，说明左半部分的点都存在
                left = mid + 1;//往右边走
            else
                right = mid -1;//mid点不存在，往左边继续找存在的
        }
        return (int)Math.pow(2, depth) - 1 + left; //d^2 - 1是前面的node数， left是最后一层的node数
    }

    private int computeDepth(TreeNode node){
        int depth = 0;
        while(node.left != null){
            node = node.left;
            depth++;
        }
        return depth;
    }

    //check if the node exist, start from root, using binary search
    private boolean exists(int index, int depth, TreeNode node){
        int left = 0, right  = (int)Math.pow(2, depth) - 1;
        int mid;
        for(int i=0; i<depth; i++){
            mid = left + (right-left)/2;//X X X mid | X X X X
            if(index <= mid){//index<=mid，说明在左半部分
                node = node.left;
                right = mid;//注意这里不是Mid-1,因为我们还是要能取到mid这个点
            }
            else{ //index>mid，说明在右半部分
                node = node.right;
                left = mid + 1;
            }
        }
        return node != null;

    }


    //每层最多2^k个node  （注意root那层k=0, 下一层k=1，以此类推）
    //如果最后一层是第d层，前面一共有2^d - 1个node，再加上第d层的node就为总共的node数
    //最后一层最多2^d个node，对这些潜在的node通过二分法来遍历，从而知道第d层最左边的node是第几个------log(2^d)=d个node
    //对二分法里的要进行测定的node，从root开始往下走，通过二分法来知道走哪条路，最后看看这个node是否存在---每个node走d深
    //Time: O(d^2)
    //Space: O(1)
}
