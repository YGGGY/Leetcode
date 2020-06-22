package Recursion;
import java.util.*;

public class GenerateParentheses_022 {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        recursion(output, "", 0, 0, n);
        return output;
    }

    private void recursion(List<String> output, String temp, int open, int close, int n){
        if(temp.length() == n * 2){
            output.add(temp);
            return;
        }
        if(open < n)
            recursion(output, temp+"(", open+1, close, n);
        if(close < open)
            recursion(output, temp+")", open, close+1, n);

    }
}
