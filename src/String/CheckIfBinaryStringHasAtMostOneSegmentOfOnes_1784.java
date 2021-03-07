package String;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes_1784 {
    public boolean checkOnesSegment(String s) {
        boolean one = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                if(one == true && s.charAt(i-1) != '1')
                    return false;
                one = true;
            }
        }
        return true;
    }
}
