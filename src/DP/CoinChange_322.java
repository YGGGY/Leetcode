package DP;

public class CoinChange_322 {
    //-----------------------------------------------
    //Top-down recursion
    public int coinChange(int[] coins, int amount) {
        if(amount < 1 || coins == null)  return 0;
        return recursion(amount, coins, new int[amount + 1]);
    }

    private int recursion(int remain, int[] coins, int[] record){
        //base case
        if(remain < 0) return -1;   //无解
        if(remain == 0) return 0;   //已经解决
        if(record[remain] != 0) return record[remain]; //从记录的数组中取出已经计算过的结果

        //遍历子问题
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            if(remain - coin < 0) continue;//子问题无解

            int subproblem = recursion(remain - coin, coins, record);
            if(subproblem != -1)        //子问题有解，更新最优子问题答案
                res = Math.min(res, subproblem);
        }

        if(res != Integer.MAX_VALUE){//子问题+1coin以后可以达到remain
            res++;  //所需coins数+1
            record[remain] = res;//记录
            return res;
        }
        else{
            record[remain] = -1;
            return -1;
        }
    }


    //------------------------------------------------

    //Bottom-up iteration
    public int coinChange2(int[] coins, int amount) {
        if(amount < 1 || coins == null)  return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int i = 1; i < amount + 1; i++){
            dp[i] = amount + 1; //Initialize 用来检查是否有解 不能用MAX_VALUE，因为后面有+1，会越界
            for(int coin : coins){
                if(i - coin < 0)    continue;

                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        if(dp[amount] < amount + 1)
            return dp[amount];
        else
            return -1;
    }
}

//看手写笔记

