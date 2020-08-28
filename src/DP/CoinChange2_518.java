package DP;

public class CoinChange2_518 {
    //--------------------------------
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        //Initialize
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i-1] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                            //不用第i个coin vs 用第i个coin凑j-coins[i-1]（dp[i][j-coins[i-1]]本身就可能包括用第i个硬币凑出来的次数
                    //LC416(01背包)的式子：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]] 不用到dp[i]
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }

    //-------------------------------
    //dp[i][j]只用到dp[i-1][..]和dp[i][..]有关
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        for(int i = 0; i <= n; i++){
            dp[0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){ //从前往后遍历，这样的dp[j-cpins[i-1]]才是dp[i]的，而不是dp[i-1]的
                if(j - coins[i-1] >= 0)
                    dp[j] = dp[j] + dp[j-coins[i-1]];
            }
        }
        return dp[amount];
    }
}
