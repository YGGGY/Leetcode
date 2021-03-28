package String;
import java.util.*;

public class NumberOfDifferentIntegersInAString_1805 {
    public int numDifferentIntegers(String word) {
        HashSet<Integer> set = new HashSet<>();
        int number = 0;
        boolean hasNum = false;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int num = Character.getNumericValue(ch);
            if(num > 9){//letter
                if(!hasNum)
                    continue;
                else{ //跟在数字后的letter
                    set.add(number);
                    number = 0;
                    hasNum = false;
                }
            }
            else{
                hasNum = true;
                number = number * 10 + num;
            }
        }
        if(hasNum)
            set.add(number);
        return set.size();
    }
}
