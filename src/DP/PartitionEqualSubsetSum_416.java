package DP;

public class PartitionEqualSubsetSum_416 {
    //-------------------------------
    //其实是0-1背包问题，等于在问用nums这些数能不能凑出sum/2的sum，剩下没有用到的数就能凑出另一外一半的sum/2
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0)    return false; //总和为奇数，不可能分成2个相等的sum

        int n = nums.length;
        sum = sum / 2;
        //dp[i][j]: 用前i个物品，当前背包容量为j。恰好装满 -> true，否则 -> false
        boolean[][] dp = new boolean[n+1][sum+1];
        //初始化
        //dp[0][...]默认为false，没东西来装
        //dp[...][0] = true  背包容量为0，一定能恰好装满
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){ //背包容量
            for(int j = 1; j <= sum; j++){ //第i个物品
                if(j - nums[i-1] < 0)   //背包放不下第i个物品
                    dp[i][j] = dp[i-1][j]; //不放第i个物品，只能能装满就装满，不能就不能
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                //不放入第i个物品 vs 放入第i个物品：容量为（总容量-第i个物品）时能装满的话，那总容量就能用第i个物品装满
            }
        }
        return dp[n][sum];
    }
    //Time: O(m * n) m = sum/2
    //Space: O(m * n)

    //----------------------------------

}
