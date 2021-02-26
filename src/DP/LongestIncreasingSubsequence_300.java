package DP;
import java.util.*;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;

        int n = nums.length;
        int[] dp = new int[n];//dp[i]：以nums[i]为结尾的增序列的max length
        Arrays.fill(dp, 1);  //初始化：dp[i] = 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        //找出最长的返回
        int res = 1;
        for(int i = 0; i < n; i ++)
            res = Math.max(res, dp[i]);
        return res;
    }

    //Time：O(n^2)
    //Space: O(n)

}
