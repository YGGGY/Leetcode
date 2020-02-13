package String;

public class LongestUncommonSubsequence_I_521 {
    public int findLUSlength(String a, String b) {
        if(a.equals(b))
            return -1;
        else
            return Math.max(a.length(), b.length());
    }
}
