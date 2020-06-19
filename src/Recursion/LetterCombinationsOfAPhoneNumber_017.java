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

    //main function
    List<String> output = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    //Recursive function
    public void backtrack(String combination, String next){
        if(next.length() == 0)//base case
            output.add(combination);//把找到的string组合添加到output里
        else{
            String digit = next.substring(0,1);//取剩下的数里的第一个数
            String letters = map.get(digit);//取这个数对应的字母们

            for(int i=0; i<letters.length(); i++){//将这个数对应的字母 分别加到之前的结果后
                String letter = letters.substring(i, i+1);//取各个字母
                backtrack(combination + letter, next.substring(1));
            }
            //+ will create a new string each time we call a recursion,
            // will not change string combination itself;
            //if we use append instead, then we need to delete the alphabet when backtrack
        }
    }
}


//【concatenation operator +】:String s=(new StringBuilder()).append("string1").append("string2").toString();
