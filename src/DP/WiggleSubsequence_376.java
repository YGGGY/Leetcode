package DP;

public class WiggleSubsequence_376 {
    // DP
    //用up[]和down[]来记录到i位置是up/down的最长长度
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    up[i] = Math.max(up[i], down[j] + 1);
                if(nums[i] < nums[j])
                    down[i] = Math.max(down[i], up[j] + 1);
            }
        }
        return Math.max(up[n-1], down[n-1]) + 1;
    }
    //Time: O(n^2)
    //Space: O(n)


    //----------------------------------------------
    //DP
    //上面这个做法，可以优化一下time complexity
    //要更新up的话，前面那个数肯定是down的，反之亦然。过nums[i]的时候，跟前一个数比较，更新能更新的数
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }
            else if(nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }
            else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(down[n-1], up[n-1]) + 1;
    }
    //Time: O(n)
    //Space: O(n)


    //-------------------------------------------
    //greedy做法，分析一下，发现实际上是取每个升/降的max/min，取中间的数不会使结果更大
    //nums[i]为max/min的特点：nums[i+1]-nums[i]和前一个区间的增减不一样
    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if(n < 2)   return n;
        int count = 0;
        int increase = nums[1] - nums[0];
        //increase > 0: 前面是递增；< 0: 前面是递减； == 0：前面不变
        if(increase != 0)
            count = 2; //开头和结尾的两个点
        else
            count = 1; //前两个点相等，开头的点随着数变化会取到，只用加上结尾的点

        for(int i = 1; i < n-1; i++){
            int diff = nums[i+1] - nums[i];
            if((diff > 0 && increase <= 0) || (diff < 0 && increase >= 0)){
                count ++;
                increase = diff;
            }
        }
        return count;
    }
    //Time: O(n)
    //Space: O(1)
}
