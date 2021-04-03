package DP;
import java.util.*;

public class WordBreak_139 {
    //----------------------------------------------
    //dfs + memo
    //从start开始找set里有的string，有的话再递归找end开始的有没有，找不到就返回false，直到全找完返回true
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return recursion(0, s, set, new int[s.length()]);
    }

    private boolean recursion(int start, String s, HashSet<String> set, int[] memo){
        if(start == s.length())
            return true;
        if(memo[start] != 0)
            return (memo[start] == 1) ?  true: false;

        for(int i = start+1; i <= s.length(); i++){
            if(set.contains(s.substring(start, i)))
                if(recursion(i, s, set, memo)){
                    memo[start] = 1;
                    return true;
                }
        }
        memo[start] = -1;
        return false;
    }

    //Time: O(n^3) 递归n^2, substring自己又要O(n)时间
    //Space: O(n)


    //----------------------------------------------
    //bfs + memo
    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[s.length()];

        while(!queue.isEmpty()){
            int start = queue.poll();
            if(visited[start])
                continue;

            for(int i = start+1; i <= s.length(); i++){
                if(set.contains(s.substring(start, i))){
                    if(i == s.length())
                        return true;
                    queue.add(i); //i作为下次检查的start
                }
            }
            visited[start] = true;
        }
        return false;
    }
    //Time: O(n^3)
    //Space: O(n)



    //-------------------------------------------------------
    //DP
    //boolean dp[i] = true, if dp[j] && substring(j,i)在set里
    public boolean wordBreak3(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];//0~i的substring能不能找到
        dp[0] = true;

        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break; //到i为止能找到对应的，不用继续找了，找i+1去
                }
            }
        }
        return dp[s.length()];
    }
    //Time: O(n^3) 2 nested loop + substring的O(n)
    //Space: O(n)
}
