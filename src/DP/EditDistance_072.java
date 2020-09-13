package DP;

public class EditDistance_072 {
    //------------------------------------------------
    //Top-down recursion using memo
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        return recursion(len1-1, len2-1, word1, word2, new int[len1][len2]);
    }

    private int recursion(int i, int j, String s1, String s2, int[][] record){
        //base case
        if(i == -1) return j+1;//s1走到头了，返回剩余的s2字符数
        if(j == -1) return i+1;//s2走到头了，返回剩余的s1字符数
        if(record[i][j] != 0)   return record[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            int subquestion = recursion(i-1, j-1, s1, s2, record); //skip
            record[i][j] = subquestion;
            return subquestion;
        }
        else{
            int sub1 = recursion(i, j-1, s1, s2, record);  //insert
            int sub2 = recursion(i-1, j, s1, s2, record);  //delete
            int sub = Math.min(sub1, sub2);
            int sub3 = recursion(i-1, j-1, s1, s2, record); //replace
            sub = Math.min(sub3, sub);  //取三种选择的最小值
            record[i][j] = sub+1;    //加上这次操作
            return sub+1;
        }
    }

    //------------------------------------------------
    //Bottom-up iteration
    public int minDistance2(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int [len1+1][len2+1]; //dp[i][j]对应第i个s1和第j个s2(s1[i-1] s2[j-1])
        //base case
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i; //s2走到头的情况：+s1剩余字符
        }
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j; //s1走到头的情况：+s2剩余字符
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    min = Math.min(min, dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[len1][len2];
    }

}
