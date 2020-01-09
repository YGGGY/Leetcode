package array;

public class ShortestWordDistance_III_245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int minDistance = words.length;

        for(int  i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                i1 = i;
            if(words[i].equals(word2)){
                if(word1.equals(word2))
                    i1 = i2;
                i2 = i;
            }
            if(i1 > -1 && i2 > -1)
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
        }
        return minDistance;
    }
}
