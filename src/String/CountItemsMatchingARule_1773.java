package String;
import java.util.*;

public class CountItemsMatchingARule_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        if(ruleKey.equals("type"))
            index = 0;
        else if(ruleKey.equals("color"))
            index = 1;
        else
            index = 2;

        int ans = 0;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).get(index).equals(ruleValue))
                ans ++;
        }
        return ans;
    }
}
