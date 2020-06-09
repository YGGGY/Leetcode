package String;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)     return  true;
        if(s.length() > t.length()) return false;

        int p1 = 0, p2 = 0;

        while(p2 < t.length() && p1 < s.length()){
            if(s.charAt(p1) == t.charAt(p2))
                p1 ++;
            p2++;
        }
        if(p1 == s.length())//p1 = s.length()-1时为最后一个字符，再+1说明最后一个字符也匹配上了
            return true;
        else
            return false;
    }
}

//time complexity: O(|T|)
//space complexity: O(1)
