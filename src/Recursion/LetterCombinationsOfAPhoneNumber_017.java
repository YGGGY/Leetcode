package Recursion;
import java.util.*;

public class LetterCombinationsOfAPhoneNumber_017 {
    HashMap<String, String> map = new HashMap<>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    ArrayList<String> output = new ArrayList<>();

    //recursion function
    public void backtrack(String combination, String next_digits){
        if(next_digits.length() == 0)
            output.add(combination);
        else{
            String digit = next_digits.substring(0,1);//get the first num (a string)
            String letters = map.get(digit);//get the alphbets in string related to the num
            for(int i = 0; i< letters.length(); i++){//concatenate all alphabets related to the num and recurse respectively
                String letter = letters.substring(i, i+1);
                backtrack(combination + letter, next_digits.substring(1));
            }
            //+ will create a new string each time we call a recursion, will not change string combination itself
            //if we use append instead, then we need to delete it when backtrack
        }
    }

    //main function
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0)
            backtrack("", digits);
        return output;
    }

}


//【concatenation operator +】:String s=(new StringBuilder()).append("string1").append("string2").toString();
