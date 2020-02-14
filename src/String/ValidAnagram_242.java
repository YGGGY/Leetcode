package String;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for(char ch : s.toCharArray()){
            alphabet[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            alphabet[ch-'a']--;
        }
        for(int i : alphabet){
            if(i != 0)
                return false;
        }
        return true;
    }
}
