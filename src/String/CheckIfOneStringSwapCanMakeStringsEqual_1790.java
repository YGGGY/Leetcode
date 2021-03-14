package String;

public class CheckIfOneStringSwapCanMakeStringsEqual_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        char temps1 = '1', temps2 = '2', temps11 = '1', temps22= '2';
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i))
                count ++;
            else{
                if(temps1 != '1'){
                    temps11 = s1.charAt(i);
                    temps22 = s2.charAt(i);
                }
                else{
                    temps1 = s1.charAt(i);
                    temps2 = s2.charAt(i);
                }
            }
        }
        if(count == s1.length())
            return true;
        if(count == s1.length()-2)
            if(temps11 == temps2 && temps22 == temps1)
                return true;
        return false;
    }
}
