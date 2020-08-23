package Stock;

public class BestTimeToBuyAndSellStock_III_123 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)    return 0;

        int dp_i20 = 0, dp_i10 = 0;
        int dp_i21 = Integer.MIN_VALUE, dp_i11 = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);// buy, 从买了1次(dp_i10)变成买了2次(dp_i21)
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);//         buy, 从买了0次(没变量)变成买了1次(dp_i11)
        }
        return dp_i20;
    }
}

//通解
//K=2，可以列举交易1次和交易2次的情况，用4个变量表示