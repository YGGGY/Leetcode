package HashMap;
import java.util.*;

public class VowelSpellchecker_966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> capital = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();

        for(String word: wordlist){
            String lower = word.toLowerCase();
            String devowel = lower.replaceAll("[aoeiu]", "*");//把元音都改成*
            capital.putIfAbsent(lower, word);
            vowel.putIfAbsent(devowel, word);
        }

        for(int i = 0; i < queries.length; i++){
            if(words.contains(queries[i]))
                continue;
            String lower = queries[i].toLowerCase();
            String devowel = lower.replaceAll("[aoeiu]", "*");
            if(capital.containsKey(lower))
                queries[i] = capital.get(lower);
            else if(vowel.containsKey(devowel))
                queries[i] = vowel.get(devowel);
            else
                queries[i] = "";
        }
        return queries;
    }
}
