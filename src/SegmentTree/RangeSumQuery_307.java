package SegmentTree;

public class RangeSumQuery_307 {
    SegTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    public void update(int index, int val) {
        updateTree(root, index, val);
    }

    public int sumRange(int left, int right) {
        return getSum(root, left, right);
    }

    private SegTreeNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;

        SegTreeNode node = new SegTreeNode(start, end);
        if(start == end) //最底层的node，只代表自己，sum就是nums里那个数
            node.sum = nums[start];
        else{ //不是最底层，往下建，然后用left和right的sum加起来作为自己的sum
            int mid = (start + end) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
            node.sum = node.right.sum + node.left.sum;
        }
        return node;
    }

    private void updateTree(SegTreeNode node, int index, int val){
        if(node.start == node.end)//找到了最底层那个只代表自己的node
            node.sum = val;
        else{ //非最底层的node，往下更新，然后用更新后的sum更新自己的sum
            int mid = (node.start + node.end) / 2;
            if(index <= mid) //
                updateTree(node.left, index, val);
            else
                updateTree(node.right, index, val);
            node.sum = node.left.sum + node.right.sum;
        }
    }

    private int getSum(SegTreeNode node, int start, int end){
        if(node.start == start && node.end == end) //找到底层node本身
            return node.sum;
        else{
            int mid = (node.start + node.end) / 2;
            if(end <= mid) //[start, end] 都在mid左边，走左子树
                return getSum(node.left, start, end);
            else if(start >= mid+1) //[start, end]都在mid+1右边，走右子树
                return getSum(node.right, start, end);
            else //[start, end]跨了mid
                return getSum(node.right, mid+1, end) + getSum(node.left, start, mid);
        }
    }


    class SegTreeNode{
        int start, end;
        SegTreeNode left, right;
        int sum;

        public SegTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
}
