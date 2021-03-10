package HashMap;
import java.util.*;

public class StrobogrammaticNumber_246 {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        HashMap<Character, Character> map = new HashMap<>(){{
            put('0','0');
            put('1','1');
            put('6','9');
            put('8','8');
            put('9','6');
        }};

        while(left <= right){
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if(!map.containsKey(leftChar) || !map.containsKey(rightChar) || map.get(leftChar) != rightChar)
                return false;

            left++;
            right--;
        }
        return true;
    }
}

//0，1，8自己上下对称，6和9在轴对称（偶数个）的情况下也能180度后相等
//本来想一个一个写返回false的条件，确实太多了
//不如写个map，在双指针遍历key的时候直接把对应应该的数保存成value