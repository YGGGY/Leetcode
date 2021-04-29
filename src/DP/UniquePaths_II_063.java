package DP;

public class UniquePaths_II_063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;//开头就gg

        int[][] dp = new int[n+1][m+1];
        dp[0][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(obstacleGrid[i-1][j-1] == 1)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
//Time: O(mn)
//Space: O(mn);
//把dp[]设成[n+1][m+1]会比设成[n][m]好做很多，不需要单独考虑i为0或j为0的情况
