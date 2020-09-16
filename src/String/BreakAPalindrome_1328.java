package String;

public class BreakAPalindrome_1328 {
    public String breakPalindrome(String palindrome) {
        char[] palin = palindrome.toCharArray();
        int n = palindrome.length();

        for(int i = 0; i < n /2; i++){ //破坏回文的话，只要把不是a的字符改成a就能破坏
            if(palin[i] != 'a'){
                palin[i] = 'a';
                return String.valueOf(palin);
            }
        }
        //回文string全是a，把最后一个a改成b
        palin[n-1] = 'b';

        if(n < 2)//palindrome=="a"
            return "";
        else
            return String.valueOf(palin);
    }
}
