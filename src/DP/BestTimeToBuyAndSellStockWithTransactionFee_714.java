package DP;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0)  return 0;

        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, temp - prices[i] - fee);
        }
        return dp_i0;
    }
}

//多个交易费就是 在买的时候多减个fee，相当于买入价变高
//为什么不在sell的时候减fee呢，因为dp_i1初始值MIN_VALUE, 减fee的时候可能越界变成MAX_VALUE那边的数