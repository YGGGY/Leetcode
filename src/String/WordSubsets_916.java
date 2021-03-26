package String;
import java.util.*;

public class WordSubsets_916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> output = new ArrayList<>();
        int[] countB = new int[26];
        for(String b : B){
            int[] temp = count(b);
            for(int i = 0; i < 26; i++){
                countB[i] = Math.max(countB[i], temp[i]);
            }
        }

        for(String a : A){
            int[] countA = count(a);
            boolean check = true;
            for(int i = 0; i < 26; i++){
                if(countA[i] < countB[i]){
                    check = false;
                    break;
                }
            }
            if(check)
                output.add(a);
        }
        return output;
    }

    private int[] count(String word){
        int[] count = new int[26];
        for(char ch : word.toCharArray()){
            count[ch - 'a'] ++;
        }
        return count;
    }
}
