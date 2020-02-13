package String;

public class LongestCommonPrefix_014 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";

        String prefix = strs[0];
        for(int i = 0; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){//找到的prefix起点不是0说明不是prefix
                prefix = prefix.substring(0, prefix.length()-1);//把目前的prefix的最后一位删去
                //注意substring(index1,index2)的subtring是[index1,index2)不包括index2
                if(prefix.isEmpty())//前缀删完了 说明不存在共同的prefix
                    return "";
            }
        }
        return prefix;
    }

}
