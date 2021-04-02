package DP;

public class OnesAndZeroes_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s : strs){
            int zero = 0, one = 0;
            for(int i = 0; i < s.length(); i++){//算这个string的0和1数
                if(s.charAt(i) == '0')
                    zero ++;
                else
                    one ++;
            }

            //一个string只能使范围内的dp[i][j]+1，要从后往前遍历，不然从小往大遍历会导致重复+1了
            for(int i = m; i >= zero; i--){ //ij不小于zero和one,小于的时候说明这个string压根不能塞进结果
                for(int j = n; j >= one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
