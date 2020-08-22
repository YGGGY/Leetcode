public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0)  return 0;

        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i] - fee);
            dp_i1 = Math.max(dp_i1, temp - prices[i]);
        }
        return dp_i0;
    }
}

//多个交易费就是 在卖的时候利润减去fee
