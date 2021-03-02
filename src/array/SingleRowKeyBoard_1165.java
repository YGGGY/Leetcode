package array;

public class SingleRowKeyBoard_1165 {
    public int calculateTime(String keyboard, String word) {
        int[] key = new int[26];
        for(int i = 0; i < 26; i++){
            int index = keyboard.charAt(i) - 'a';
            key[index] = i;
        }

        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(i == 0){
                count += key[word.charAt(i)-'a'];
            }
            else{
                count += Math.abs(key[word.charAt(i)-'a']-key[word.charAt(i-1)-'a']);
            }
        }
        return count;
    }
}
//用int[]来记录每个char在键盘的位置，每次移动的时候取char的index相减就完事了