package DP;
import java.util.*;

public class PerfectSquares_279 {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //计算candidate平方数
        int squareMax = (int)Math.sqrt(n) + 1;
        int[] square = new int[squareMax];
        for(int i = 1; i < squareMax; i++){
            square[i] = i * i;
        }

        for(int i = 1; i <= n; i++){//dp[i]
            for(int j = 1; j < squareMax; j++){//square[j]
                if(i < square[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i-square[j]] + 1);
            }
        }
        return dp[n];

    }

    //Time: O(n根号（n）)
    //Space: O(n)

    //numSquares(n) = min(numSquare(n-k)) + 1, where k is a square number
}

