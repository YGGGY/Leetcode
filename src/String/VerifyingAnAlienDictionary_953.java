package String;
import java.util.*;

public class VerifyingAnAlienDictionary_953 {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length-1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j >= words[i+1].length())
                    return false; //前面的char都相等，但是后一个word比前一个长，顺序错了

                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    int currentOrder = map.get(words[i].charAt(j));
                    int nextOrder = map.get(words[i+1].charAt(j));
                    if(currentOrder > nextOrder)
                        return false;
                    else
                        break;//check next word
                }
            }
        }
        return true;
    }
}
