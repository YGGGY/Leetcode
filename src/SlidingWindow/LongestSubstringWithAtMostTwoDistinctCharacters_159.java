package SlidingWindow;
import java.util.*;

public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
            if(map.size() > 2){
                int left = s.length()+1;
                for(int index : map.values()){
                    left = Math.min(left, index);
                }
                map.remove(s.charAt(left));
                start = left+1;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
//和340一个意思