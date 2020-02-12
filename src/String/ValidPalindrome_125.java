package String;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;

        int left = 0, right = s.length() - 1;
        char cleft, cright;
        while(left <= right){
            cleft = s.charAt(left);
            cright = s.charAt(right);
            if(!Character.isLetterOrDigit(cleft))//only number or alphabet count
                left++;
            else if(!Character.isLetterOrDigit(cright))
                right--;
            else if(Character.toLowerCase(cleft) != Character.toLowerCase(cright))
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
//two pointer
