package Stock;

public class BestTimeToBuyAndSellStock_121 {
    //-------------------------------------
    //这道题单独的解法，本质是找当前最小数和这个数之后有没有更大的profit（差值）
    public int maxProfit2(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for(int i = 0; i< prices.length; i++){
            if(prices[i] < min_price)
                min_price = prices[i];
            else if(prices[i] - min_price > max_profit)
                max_profit = prices[i] - min_price;
        }
        return max_profit;

    }

    //-------------------------------------
    //股票问题通解
    //K = 1, 新状态只和前一天状态油管，不需要k这个参数，用2个变量表示昨天的[0]和[1]就行
    //需要注意buy的情况下不能加上dp[i][0]
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)  return 0;

        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, - prices[i]);//注意这里不是dp_i0 - prices[i]，因为只能买1次，所以之前一定profit == 0
        }
        return dp_i0;
    }

}