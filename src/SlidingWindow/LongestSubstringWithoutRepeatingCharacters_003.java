package SlidingWindow;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters_003 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                int index = map.get(ch);
                if(index >= i) //这个ch在window(substring)里
                    i = index + 1;
            }
            max = Math.max(max, j - i + 1);
            map.put(ch, j);
        }
        return max;
    }
}

//Time: O(n), for index j interate though the string
//Space: O(min(m,n)) n for the length of string s, and m for number of alphabet

//如果用Hashset来做，则ij都要遍历2次string，time会变成O(2n)