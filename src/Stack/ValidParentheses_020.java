package Stack;
import java.util.*;

public class ValidParentheses_020 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for(char ch : s.toCharArray()){
            if(ch == ')' || ch == '}' || ch == ']'){
                if(stack.isEmpty())
                    return false;
                else{
                    char key = stack.pop();
                    if(map.get(key) != ch)
                        return false;
                }
            }
            else{
                stack.push(ch);
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
