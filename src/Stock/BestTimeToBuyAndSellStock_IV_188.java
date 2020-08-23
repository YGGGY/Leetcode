package Stock;

public class BestTimeToBuyAndSellStock_IV_188 {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices == null || prices.length == 0)  return 0;

        int n = prices.length;
        if(k > n/2 + 1){       //等效于k无限制 LC122那题
            int maxProfit = 0;
            for(int i = 1; i < n; i++){
                if(prices[i] > prices[i-1])
                    maxProfit += prices[i] - prices[i-1];
            }
            return maxProfit;
        }
        else{                 //遍历i和k
            int[][][] dp = new int[n][k+1][2];

            for(int i = 0; i < n; i++){
                for(int j = k; j > 0; j--){
                    if(i == 0){         //base case
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];//不能写MIN_VALUE, dp[0][k][1]本来就应该取-prices[0]
                                                 //其他题写MIN_VALUE是因为i=0在下面的for循环中，会经过一次计算让它变成-prices[0]
                    }
                    else{
                        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                    }
                }
            }
            return dp[n-1][k][0];
        }
    }
}
