package Recursion;
import java.util.*;

public class WordBreak_II_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();//用map来记录当前string有哪些break法
        return recursion(s, wordDict, map);
    }

    private List<String> recursion(String s, List<String> wordDict, HashMap<String, List<String>> map){
        if(map.containsKey(s))//有保存过的中间答案，直接返回
            return map.get(s);

        List<String> ans = new ArrayList<>();

        for(String word: wordDict){//找能匹配上s前面的word，然后递归找后面的，最后把word加上这些结果返回
            if(s.length() >= word.length() && s.substring(0, word.length()).equals(word)){
                if(s.length() == word.length())//到最后一部分了
                    ans.add(word);
                else{
                    List<String> remainAns = recursion(s.substring(word.length()), wordDict, map);//剩余string的解法list
                    //把这个word加到s的substring的答案list里的各个string前面, 加完以后加到ans里来return给上一级
                    for(String remain : remainAns){
                        String newAns = word + " " + remain;
                        ans.add(newAns);
                    }
                }

            }
        }
        map.put(s, ans);
        return ans;
    }
}
