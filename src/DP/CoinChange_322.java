package DP;

public class CoinChange_322 {

    //Top-down recursion
    public int coinChange(int[] coins, int amount) {
        if(amount <1)   return 0;
        return helper(coins, amount, new int[amount]);
    }

    //count[remain]: min number of coins to get the remaining number
    private int helper(int[] coins, int remain, int[] count){
        //结束条件
        if(remain < 0) return -1;//not a valid solutio
        if(remain == 0) return 0;//completed
        if(count[remain - 1] != 0) return count[remain - 1];//用前面得到过的结果
        //count[remain-1]!=0 说明这个是计算过的结果，而不是初始化时的0
        //要remain-1是因为只创了amount个数，index为0的地方代表amount为1

        int min = Integer.MAX_VALUE;
        for(int coin:coins){//取各种coin的情况，往下走
            int res = helper(coins, remain - coin, count);
            if(res >= 0 && res < min)//res>=0说明是valid solution
                                     //min是这层以下所有结果的min
                min = 1 + res;//这层用了各种coin，1为这层，所以层数+1
        }

        if(min != Integer.MAX_VALUE){
            count[remain-1] = min;
            return min;
        }
        else{
            count[remain-1] = -1;
            return -1;
        }
    }


    //------------------------------------------------

    //Bottom-up iteration
    public int coinChange2(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] dp = new int[amount+1];
        int sum = 1;

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
