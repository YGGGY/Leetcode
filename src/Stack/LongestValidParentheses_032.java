package Stack;
import java.util.*;

public class LongestValidParentheses_032 {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        int start = 0 , ans = 0;
        Deque<Integer> stack = new ArrayDeque();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                if(stack.isEmpty()) //有)没(, 匹配不上，更新可能的start
                    start = i + 1;
                else{
                    stack.pop();
                    if(stack.isEmpty()) //都匹配上了 计算从start开始的长度
                        ans = Math.max(ans, i - start + 1);
                    else //匹配上了一个(，还有(待匹配，先计算到目前匹配的长度
                        ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
