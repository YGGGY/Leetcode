package String;
import java.util.*;

public class ExpressiveWords_809 {

}

class RLE{
    String key;
    List<Integer> counts;

    public RLE(String S){
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] Schar = S.toCharArray();
        int len = Schar.length;
        int prev = -1;

        for(int i = 0; i < len; i++){
            if(i == len-1 || Schar[i] != Schar[i+1]){
                //遍历到最后一个数   //或者这个数不等于后一个数->是单独的数/一连串相等的数中的最后一个
                sb.append(Schar[i]);//把这个数加进去
                counts.add(i - prev);//这个数出现的次数=最后一个数出现的index - 一连串数的前一个数的index
                prev = i;//标志这串数结束计数，用于下串数计数
            }
        }

        key = sb.toString();
    }
}
