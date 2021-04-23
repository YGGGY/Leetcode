package Stack;
import java.util.*;

public class MinimumRemoveToMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty())
                    stack.pop();
                else
                    set.add(i);
            }
        }
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }

        String ans = "";
        for(int i = 0; i < s.length(); i++){
            if(!set.contains(i))
                ans += s.charAt(i);
        }
        return ans;
    }
}
//遇到(压入栈，遇到)把栈顶pop了，如果这是栈为空，则要去掉这个index的）。如果遍历完栈不为空，则要去掉栈里的（
//把要去掉的index存到set里，最后生成ans的时候不加入ans
//Time: O(n)
//Space: O(n)
