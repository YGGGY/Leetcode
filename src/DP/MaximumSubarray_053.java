package DP;

public class MaximumSubarray_053 {
    //-----------------------------------
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;

        int n = nums.length;
        int[] dp = new int[n]; //dp[i]: 以nums[i]为结尾的array的max sum
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]); //自成一派 vs 和前一个数连在一起
        }

        //找出最长的返回
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    //Time: O(n)
    //Space: O(n)

    //----------------------------------
    //dp[i]的状态只和dp[i-1]有关，用变量代替dp[i-1]就行
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;

        int dp = nums[0];
        int res = dp;
        for(int i = 1; i < nums.length; i++){
            dp = Math.max(nums[i], dp + nums[i]);
            res = Math.max(res, dp);
        }

        return res;
    }
    //Time: O(n)
    //Space: O(1)
}
