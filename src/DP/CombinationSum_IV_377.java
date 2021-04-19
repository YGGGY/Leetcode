package DP;

public class CombinationSum_IV_377 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(i - num >= 0)
                    dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}

//和coin change2不一样，这题其实不是算combination而是算permutation， 112和121算两种
//这题和coinchange2的嵌套循环反了过来，coinchange2是前i个coin-凑j，这题是凑i，分别加第j个数到当前排列最后