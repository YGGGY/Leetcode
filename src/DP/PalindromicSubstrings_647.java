package DP;

public class PalindromicSubstrings_647 {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        boolean[][] dp = new boolean[n][n];//dp[i][j]: i~j这个substring是否回文
        int ans = n;//每个字母本身算1个

        //base case len=1时
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        //base case len=2时
        for(int i = 0; i < n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                ans ++;
            }
        }

        //len>=3时
        for(int len = 3; len <= n; len++){
            for(int i = 0; i+len-1 < n; i++){
                int j = i + len - 1;
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    ans ++;
                }
            }
        }
        return ans;
    }
}


//dp[i][j]: i~j这个substring是否回文
//base case: dp[i][i] = true, dp[i][i+1]则看s[i] s[j]
//dp[i][j] 取决于dp[i+1][j-1]和s[i] == s[j]?


//Time: O(n^2)
//Space: O(n^2)