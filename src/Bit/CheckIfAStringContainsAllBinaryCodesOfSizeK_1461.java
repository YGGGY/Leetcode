package Bit;
import java.util.*;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK_1461 {
    //最直接的做法，用set来保存2^k个符合条件的substring
    //和对着所有的可能的k长度的string来比较查不同，
    //反方向思考，取s的每个len为k的substring，存在set里，利用set不重复的原理，可以存substring能凑出的所有情况
    //最后看有这种substring有多少个
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k)  return false;

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i <= s.length()-k; i++){
            set.add(s.substring(i,i+k));
        }

        if(set.size() == Math.pow(2,k))
            return true;
        else
            return false;
    }
    //Time: O(n * k) 每个substring，花k的时间算hash
    //Space: O(2^k * n)

    //为了节省时间，可以把每个len为k的substring转成int作为array的index，用boolean来表示存没存过
    public boolean hasAllCodes2(String s, int k) {
        if(s.length() < k)  return false;

        int total = 1 << k; //2^k
        int count = 0;
        boolean[] get = new boolean[total];
        int hash = 0;
        int allOne = total - 1; //比2^k少一位的全是1的数
        for(int i = 0; i < s.length(); i++){
            //用之前的hash来算现在的hash值， 取前一个hash的后k-1位，往前1位，末尾加上新的0/1
            //<<1使hash末尾多一位0，用(k-1)个1做&使首位的数去掉，
            hash = (hash << 1) & allOne | (s.charAt(i) - '0');
            if(i >= k-1 && !get[hash]){
                get[hash] = true;
                count ++;
            }
        }
        if(count >= Math.pow(2,k))
            return true;
        else
            return false;
    }
}
