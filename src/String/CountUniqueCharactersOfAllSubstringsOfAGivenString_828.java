package String;
import java.util.*;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString_828 {
    public int uniqueLetterString(String s) {
        List<Integer>[] record = new List[26];//记录A-Z字母出现的index
        for(int i = 0 ; i < 26; i++){
            record[i] = new ArrayList<>();
        }

        for(int i = 0; i < s.length(); i++){
            record[s.charAt(i) - 'A'].add(i);
        }

        long result = 0;
        for(int i = 0; i < 26; i++){
            int size = record[i].size();
            for(int j = 0 ; j < size; j++){
                int pos = record[i].get(j);
                int leftPos = (j == 0)? -1 : record[i].get(j-1);//该字母第一次出现的index，左边有index个字符，
                //有index+1个分割方法，所以leftPos设成-1
                int rightPos = (j == size-1)? s.length() : record[i].get(j+1);//该字母最后一次出现的index，右边有n-index-1个字符
                //有n-index个分割方法，所以rightPos设成n
                result += (pos - leftPos) * (rightPos - pos);
                result = result % 1000000007;
            }
        }
        return (int)result;
    }
}

//这题的思路要从每个字符想
//对 XAXAXXAX 的第二个A字符来说，需要把3个A分在不同的string，才能使得A被count， 为count数+1
//第一个和第二个A字符之间有2个分法，第二个和第三个A字符之间有3个分法，那么使得这个A被count的substring一共有6种
//对于这个string里的每个字符，找到使它count有多少个substring，加在一起，就是想要的结果
//对于字符A来说，它的index为pos，找到它左边的A在leftPos，右边的A在rightPos，
//  substring数就是(pos - leftPos) * (rightPos - pos)
//把所有字符的所有出现的index都算一遍这个，加在一起就是结果


//Time: O(n)
//Space: O(n)