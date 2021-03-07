package DP;
import java.util.*;

public class PalindromeParititioning_III_1278 {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        //算cost[j][i] 把s[j,i]变成回文所需最小改动字符数
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                cost[j][i] = s.charAt(i) == s.charAt(j)? 0 : 1;
                if(i - j > 2) //i-j == 2的时候为axc型，只要把c改成a这一个动作就行
                    cost[j][i] += cost[j+1][i-1]; //两个指针往里面走，把cost加起来
                //因为用到j+1和i-1，所以i正序遍历，j倒序遍历
            }
        }

        int[][] dp = new int[n][k+1];
        for(int[] d : dp){
            Arrays.fill(d, 100000);
        }

        for(int i = 0; i < n; i++){
            dp[i][1] = cost[0][i];
            for(int ki = 2; ki <= Math.min(k,i+1); ki++){
                for(int j = ki-1; j <= i; j++){
                    dp[i][ki] = Math.min(dp[i][ki], dp[j-1][ki-1] + cost[j][i]);
                }
            }
        }
        return dp[n-1][k];

    }
}
