package String;

public class ValidPalindrome_II_680 {
    public boolean validPalindrome(String s) {
        int length = s.length();
        if(length == 0) return false;
        int left = 0;
        int right = length - 1;

        while(left <= right){
            char cleft = s.charAt(left);
            char cright = s.charAt(right);
            //遇到不符合的，要么去掉左边的，要么去掉右边的。分别对这两个substring检查回文
            if(cleft != cright){
                if(palindromeRange(s, left+1, right)||palindromeRange(s, left, right-1))
                    return true;
                else
                    return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean palindromeRange(String s1, int left0, int right0){
        while(left0 <= right0){
            char cleft0 = s1.charAt(left0);
            char cright0 = s1.charAt(right0);
            if(cleft0 != cright0)
                return false;
            else{
                left0++;
                right0--;
            }
        }
        return true;
    }
}
