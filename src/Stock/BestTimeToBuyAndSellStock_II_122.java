package Stock;

public class BestTimeToBuyAndSellStock_II_122 {
    //---------------------------------
    //这道题单独的解法，把所有在上涨的都加进profit
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        for(int i = 1; i < prices.length; i++){//有i-1，注意从i=1开始
            if(prices[i] > prices[i-1])
                max_profit += prices[i] - prices[i-1];
        }
        return max_profit;
    }
    //只要能想明白，一旦到达短暂的最高价就卖（即在降价前抛售），是最获利的就行
    //不需要等到最高价再卖，只要降价了，降之前就卖，降了就买。只要有降价的情况，每个爬坡加起来会比总体的高度要大


    //----------------------------------
    //股票问题通解
    //可以买无数次，所以不需要k这个参数，用2个变量正常写就行
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0)    return 0;

        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, temp - prices[i]);
        }
        return dp_i0;
    }
}
