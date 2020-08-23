package Stock;

public class BestTimeToBuyAndSellStockWithCooldown_309 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)  return 0;

        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        int dp_pre0 = 0;
        for(int i = 0; i < prices.length; i++){
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, dp_pre0 - prices[i]);
            dp_pre0 = temp;
        }
        return dp_i0;
    }
}

//通解
//dp_i1的是式子中，dp[i-1][o]要变成dp[i-2][0]。这里用dp_pre0来记录前天的记录