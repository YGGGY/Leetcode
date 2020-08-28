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

        for(int i = 1; i <= n; i++){ //第i个物品
            for(int j = 1; j <= sum; j++){ //背包容量
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
    //dp[i][j]的状态只和dp[i-1][j], dp[i-1][j-nums[i]]有关，可以去掉i维度
    //因为更新j的时候需要看dp[i-1][k](k<j)时的数据，所以j要从后往前遍历。从前往后遍历的话，更新j时会基于新的dp[k]，这个dp[j]实际上是dp[i][k]
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0)    return false; //总和为奇数，不可能分成2个相等的sum

        int n = nums.length;
        sum = sum / 2;

        boolean[] dp = new boolean[sum+1];
        //初始化
        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = sum; j > 0; j--){
                if(j - nums[i-1] >= 0)   //背包放的下第i个物品
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                //不放入第i个物品 vs 放入第i个物品：容量为（总容量-第i个物品）时能装满的话，那总容量就能用第i个物品装满
            }
        }
        return dp[sum];
    }
}
