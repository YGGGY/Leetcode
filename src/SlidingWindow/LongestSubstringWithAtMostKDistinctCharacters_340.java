package SlidingWindow;
import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);   //就算是之前有的char，也要update它在的index
            if(map.size() > k){ //string里的char类型达到上限，需要删掉一个
                int left = s.length()+1;
                for(int index : map.values()){ //找最左边的删掉
                    left = Math.min(left, index);
                }
                map.remove(s.charAt(left));
                start = left + 1;
            }
            else{
                ans = Math.max(ans, i-start+1);
            }
        }
        return ans;
    }
}
