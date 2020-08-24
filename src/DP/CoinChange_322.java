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
        if(amount < 1) return 0;

        int[] dp = new int[amount+1];
        int sum = 1;//从1开始一点点Bottom-up，计算到sum需要的coins数

        while(sum <= amount){//sum为当前计算的需要得到的sum，dp[sum]为得到sum所需要的coins数
            int min = -1;
            for(int coin:coins){
                if(sum >= coin && dp[sum-coin] != -1){//dp[sum-coin]== -1说明达不到这个sum，所以没法在这个sum的基础上加个coin得到新的sum
                    int temp = dp[sum-coin] + 1;//取之前得出的最低结果
                    if(min < 0 || temp < min){//min<0说明之前没得出过结果
                                              //temp<min说明新的结果更好，即min{now,temp}这步
                        min = temp;
                    }
                }
            }
            dp[sum] = min;//min是得到sum这么多amount所需要的coins数的最小值
            sum++;
        }
        return dp[amount];
    }
}

//看手写笔记

