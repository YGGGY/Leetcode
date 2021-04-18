package String;

public class CheckIfTheSentenceIsPangram_1832 {
    public boolean checkIfPangram(String sentence) {
        int[] letter = new int[26];
        for(char ch : sentence.toCharArray()){
            int index = ch - 'a';
            letter[index] = 1;
        }
        for(int i = 0; i < 26; i++){
            if(letter[i] != 1)
                return false;
        }
        return true;
    }
}
