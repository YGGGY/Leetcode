package String;
import java.util.*;

public class ExpressiveWords_809 {
    public int expressiveWords(String S, String[] words) {
        if(S == null || S.length() == 0 || words == null || words.length==0)
            return 0;

        int result = 0;
        List<Pair> countS = getCount(S);//
        for(String w: words){//对words里的每个string检查是否可以
            if(isMatch(countS, getCount(w)))
                result++;
        }
        return result;
    }

    private List<Pair> getCount(String s){
        List<Pair> count = new ArrayList<>();//list of pair
        for(int i = 0; i < s.length(); i++){
            int c = 1;
            //对每个连续相同的计数
            while(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)){//如果和后面的相等，就一直数下去
                c++;
                i++;
            }
            count.add(new Pair(s.charAt(i),c));
        }
        return count;
    }

    private boolean isMatch(List<Pair> countS, List<Pair> countW){
        if(countS.size() != countW.size())
            return false;

        for(int i = 0; i < countS.size(); i++){
            //字符不相等
            if(countS.get(i).ch != countW.get(i).ch)
                return false;
            //字符相等
            //字符在S中出现次数<3时，在S和W的次数要相等才行
            if(countS.get(i).count < 3){
                if(countS.get(i).count != countW.get(i).count)
                    return false;
            }
            //字符在S中出现次数>=3，只要S的次数>= W的即可通过扩展得到，反言之S的次数< W则不行
            else if(countS.get(i).count < countW.get(i).count)
                return false;
        }
        return true;
    }
}

class Pair{
    char ch;
    int count;

    public Pair(Character ch, int count){
        this.ch = ch;
        this.count = count;
    }
}

