package String;

public class TruncateSentence_1816 {
    public String truncateSentence(String s, int k) {
        int count = 0;
        String ans = "";
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                count ++;
                if(count == k)
                    ans = s.substring(0,i);
            }
        }
        if(ans == "")
            return s;
        else
            return ans;
    }
}
