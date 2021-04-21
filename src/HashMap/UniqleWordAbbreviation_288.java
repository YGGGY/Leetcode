package HashMap;
import java.util.*;

public class UniqleWordAbbreviation_288 {
    private Map<String, Set<String>> abbr;

    public ValidWordAbbr(String[] dictionary) {
        abbr = new HashMap<>();
        for(String word : dictionary){
            String abbrWord = getAbbr(word);
            abbr.putIfAbsent(abbrWord, new HashSet<String>());
            abbr.get(abbrWord).add(word);
        }
    }

    public boolean isUnique(String word) {
        String abbrWord = getAbbr(word);
        if(!abbr.containsKey(abbrWord))
            return true;
        else if(abbr.get(abbrWord).contains(word) && abbr.get(abbrWord).size() == 1)
            return true;
        return false;
    }

    private String getAbbr(String word){
        String ans = "";
        ans += word.charAt(0);
        if(word.length() > 2)
            ans += String.valueOf(word.length()-2);
        ans += word.charAt(word.length()-1);
        return ans;
    }
}
