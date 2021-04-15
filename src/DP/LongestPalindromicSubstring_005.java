package DP;

public class LongestPalindromicSubstring_005 {
    //-------------------------------
    //brute force: 穷举所有substring，再判断是否回文
    //Time: O(n^3),n^2个substring，每个O(n)时间check回文
    //space: O(1)

    //-------------------------------
    //dp
    //boolean: dp[i][j] : s[i,j]是否是回文
    //通过dp[i-1][j-1]和s[i]==s[j]来决定dp[i]，区间型DP
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        String ans = "";

        for(int len = 1; len <= n; len ++){
            for(int i = 0; i+len-1 < n; i++){
                if(len == 1)    dp[i][i] = true;
                else if(len == 2)
                    dp[i][i+1] = (s.charAt(i) == s.charAt(i+1))? true: false;
                else{
                    if(dp[i+1][i+len-2] && s.charAt(i) == s.charAt(i+len-1))
                        dp[i][i+len-1] = true;
                }

                if(dp[i][i+len-1] && len > max){
                    max = len;
                    ans = s.substring(i, i+len);
                }
            }
        }
        return ans;
    }
    //Time: O(n^2)
    //Space: O(n^2)


    //----------------------------------------
    //不记录每个substring的情况，而是考虑对每个char，以char为中心是否为substring
    //奇数长度substring里mid为中心，偶数长度substring里mid为左中心
    public String longestPalindrome2(String s) {
        int start = 0, len = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){ //以i为中心点的最长palindromic substring
            int len1 = getLen(s, i, i);//奇数长度，i为中心
            int len2 = getLen(s, i, i+1);//偶数长度，i为左中心，i+1为右中心
            int curr = Math.max(len1, len2);
            if(curr > len){
                len = curr;
                start = i - (len-1)/2;//计算i为中心/左中心的substring的起始index
            }
        }
        return s.substring(start, start + len);
    }

    private int getLen(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        //注意跳出while的时候，left和right是越界的情况，我们想要的left其实是left+1，right是right-1
        //实际上是len = (right-1)-(left+1)+1，化简以后是right-left-1
        return right - left - 1;
    }

    //Time: O(n^2)
    //Space: O(1)
}
