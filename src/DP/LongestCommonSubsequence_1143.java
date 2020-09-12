package DP;

public class LongestCommonSubsequence_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
    //Time: O(m * n)
    //Space: O(m * n)

    //-------------------------------------
    //为了节省空间，可以only keep tracking of the last 2 columns
    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        if(len2 < len1){//让text1成为较短的string
            String temp = text1;
            text1 = text2;
            text2 = temp;
            int len = len1;
            len1 = len2;
            len2 = len;
        }

        int[] previous = new int[len1+1];
        for(int j = 1; j <= len2; j++){
            int[] current = new int[len1+1];
            for(int i = 1; i <= len1; i++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    current[i] = previous[i-1] + 1;
                else
                    current[i] = Math.max(current[i-1], previous[i]);
            }
            //current becomes previous
            previous = current;
        }
        return previous[len1];
        //Time: O(m * n)
        //Space: O(min(m, n))
    }
}
