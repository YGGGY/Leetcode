package DP;

public class CoinChange_322 {

    //Top-down recursion
    public int coinChange(int[] coins, int amount) {
        if(amount <1)   return 0;
        return helper(coins, amount, new int[amount]);
    }

    //count[remain]: min number of coins to get the remaining number
    private int helper(int[] coins, int remain, int[] count){
        if(remain < 0) return -1;//not a valid solutio
        if(remain == 0) return 0;//completed
        if(count[remain - 1] != 0) return count[remain - 1];//用前面得到过的结果
        //count[remain-1]!=0 说明这个是计算过的结果，而不是初始化时的0
        //要remain-1是因为只创了amount个数，index为0的地方代表amount为1

        int min = Integer.MAX_VALUE;
        for(int coin:coins){//取各种coin的情况，往下走
            int res = helper(coins, remain - coin, count);
            if(res >= 0 && res < min)
                min = 1 + res;//这层用了各种coin，1为这层，所以层数+1
        }
        count[remain-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remain - 1];
    }
}
