package DP;

public class MinimumSidewayJumps_1824 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length-1;
        int[][] dp = new int[n+1][4];//到index处各个lane需要的步数
        dp[0][1] = 1;
        dp[0][2] = 0;
        dp[0][3] = 1;

        for(int i = 1; i <= n; i++){
            int min = n*2;
            for(int j = 1; j <= 3; j++){ //之前的lane直接往前走
                if(j == obstacles[i])
                    dp[i][j] = Integer.MAX_VALUE; //这个格子是障碍物
                else
                    dp[i][j] = dp[i-1][j];
                min = Math.min(min, dp[i][j]); //求出3个lane的最短
            }

            for(int j = 1; j <= 3; j++){//对于不是最短路径的格子，可以从其他格子那里jump过来(除了堵了的）
                if(dp[i][j] != min && j != obstacles[i])
                    dp[i][j] = min + 1;
            }
        }

        int ans = n * 2;
        for(int j = 1; j <= 3; j++){
            ans = Math.min(ans, dp[n][j]);
        }
        return ans;
    }
}
