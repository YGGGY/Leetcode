package String;

public class DetermineIfStringHalvesAreAlike_1704 {
    public boolean halvesAreAlike(String s) {
        String vowel = "aoeiuAOEIU";
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < s.length()/2; i++){
            if(vowel.indexOf(s.charAt(i)) != -1)
                countA ++;
        }

        for(int i = s.length()/2; i < s.length(); i++){
            if(vowel.indexOf(s.charAt(i)) != -1)
                countB ++;
        }
        if(countA == countB)
            return true;
        else
            return false;
    }
}
