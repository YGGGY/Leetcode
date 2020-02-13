package String;
import java.util.*;

public class FindAllAnagramsInAString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int len_s = s.length(), len_p = p.length();
        if(len_s < len_p)
            return new ArrayList();

        HashMap<Character, Integer> pCount = new HashMap();
        HashMap<Character, Integer> sCount = new HashMap();
        //把p做hashmap
        for(int i = 0; i < len_p; i++){
            char ch = p.charAt(i);
            if(pCount.containsKey(ch))
                pCount.put(ch, pCount.get(ch) + 1);
            else
                pCount.put(ch, 1);
        }

        List<Integer> output = new ArrayList();
        for(int i = 0; i < len_s; i++){
            char ch = s.charAt(i);
            if(sCount.containsKey(ch))
                sCount.put(ch, sCount.get(ch) + 1);
            else
                sCount.put(ch, 1);
            //slide 1 step
            if(i >= len_p){
                ch = s.charAt(i - len_p);//删去window的前一个数
                if(sCount.get(ch) == 1)
                    sCount.remove(ch);
                else
                    sCount.put(ch, sCount.get(ch) - 1);
            }
            //check
            if(pCount.equals(sCount)){
                output.add(i - len_p + 1);//i-len_p+1为符合的window的起始index
            }
        }
        return output;
    }
}
