package DP;
import java.util.*;

public class ConcatenatedWords_472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        for(String candidate : words){//将words里每个string视为concatenate来试试，试的时候要删掉自己本身
            set.remove(candidate);
            if(isCon(candidate, set))
                ans.add(candidate);
            set.add(candidate);
        }
        return ans;
    }

    private boolean isCon(String s, HashSet<String> set){
        if(s.length() == 0 || s == null)
            return false;
        if(set.isEmpty())
            return false;

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
//做法和wordbreak差不多，但是这题没法用dfs+memo，因为s一直在变，除非再写一个check function来递归调用