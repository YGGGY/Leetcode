package Recursion;
import java.util.*;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        recursion(s, 0, new ArrayList<String>(), output);
        return output;
    }

    private void recursion(String s, int start, List<String> temp, List<List<String>> output){
        if(start >= s.length()){
            output.add(new ArrayList<String>(temp));
        }
        else{
            for(int i = start; i < s.length(); i++){//只管后面的string怎么切，不管之前的
                if(!isPalindrome(s.substring(start, i+1)))//split一个回文出来
                    continue;
                temp.add(s.substring(start, i+1));
                recursion(s, i+1, temp, output);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
