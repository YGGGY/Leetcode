package DP;

public class ShortestCommonSupersequence_1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        //LCS的dp过程
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(len1 >= 1 || len2 >= 1){
            if(len1 < 1){//str1遍历完了
                while(len2 >= 1){
                    sb.append(str2.charAt(len2-1));
                    len2--;
                }
            }
            else if(len2 < 1){//str2遍历完了
                while(len1 >= 1){
                    sb.append(str1.charAt(len1-1));
                    len1--;
                }
            }
            else if(str1.charAt(len1-1) == str2.charAt(len2-1)){//相等的加上去 其实这是LCS的一部分
                sb.append(str1.charAt(len1-1));
                len1--;
                len2--;
            }
            else{   //把dp大的那个加上去
                if(dp[len1-1][len2] >= dp[len1][len2-1]){
                    sb.append(str1.charAt(len1-1));
                    len1--;
                }
                else{
                    sb.append(str2.charAt(len2-1));
                    len2--;
                }
            }
        }
        return sb.reverse().toString();
    }
}

//先求出LCS，再从后往前把char append到StringBuilder上
//s[i]和t[j]相等的直接加；不相等的把dp[i][j]大的加上去；一个加完了就把另一个剩下的全加了

//Time: O(m * n)
//Space: O(m * n)