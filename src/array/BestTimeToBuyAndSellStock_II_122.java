package array;

public class BestTimeToBuyAndSellStock_II_122 {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        for(int i = 1; i < prices.length; i++){//有i-1，注意从i=1开始
            if(prices[i] > prices[i-1])
                max_profit += prices[i] - prices[i-1];
        }
        return max_profit;
    }
}

//只要能想明白，一旦到达短暂的最高价就卖（即在降价前抛售），是最获利的就行
//不需要等到最高价再卖，只要降价了，降之前就卖，降了就买。只要有降价的情况，每个爬坡加起来会比总体的高度要大