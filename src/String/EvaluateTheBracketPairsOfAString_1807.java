package String;
import java.util.*;

public class EvaluateTheBracketPairsOfAString_1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> know : knowledge){
            String key = know.get(0);
            String value = know.get(1);
            map.put(key, value);
        }

        int n = s.length();
        String ans = "";
        boolean checking = false;
        String checkKey = "";
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!checking && ch != '(')
                ans = ans + ch;
            else if(ch == '('){
                checking = true;
                checkKey = "";
            }
            else if(ch == ')'){
                checking = false;
                String checkValue = map.getOrDefault(checkKey, "?");
                ans = ans + checkValue;
            }
            else{ //checking word
                checkKey = checkKey + ch;
            }
        }
        return ans;
    }
}
