package DP;

public class CoinChange2_518 {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        if(coins.length == 0)   return 0;
        if(amount < coins[0])   return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = 1; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(coins[i-1] <= j)
                    dp[j] += dp[j - coins[i-1]];
            }
        }
        return dp[amount];
    }
}
//看手写笔记