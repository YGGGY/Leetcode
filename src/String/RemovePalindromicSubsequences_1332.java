package String;

public class RemovePalindromicSubsequences_1332 {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1)   return 1;
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return 2;
            left ++;
            right --;
        }
        return 1;
    }
}

//这道题关键是想明白只有0，1，2这三种返回可能
//如果s本身是个回文，返回1；s不是回文，返回2
//因为对于非回文，第一次把a抽完，第二次把b抽完，就抽空了