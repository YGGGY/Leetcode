package Greedy;
import java.util.*;

public class StampingTheSequence_936 {
    public int[] movesToStamp(String stamp, String target) {
        int count = 0; //改过的字符数
        int stampLen = stamp.length(), targetLen = target.length();
        char[] targetArray = target.toCharArray();
        char[] stampArray = stamp.toCharArray();
        List<Integer> res = new ArrayList<>();

        boolean changed = true;
        while(changed){//前一轮遍历完changed还是为false，说明已经没有可以戳的字符了
            changed = false;
            //找能让stamp戳的起始位置，即和stamp匹配的substring的位置
            for(int start = 0; start <= targetLen - stampLen; start++){
                boolean changeable = false;
                int i = start, j = 0;
                while(j < stampLen){
                    //比较target从i开始的stampLen个 是否和stamp匹配 ：要么相等，要么该位为*
                    if(targetArray[i] != stampArray[j] && targetArray[i] != '*')//不匹配，不能戳
                        break;
                    else if(targetArray[i] == stampArray[j])
                        changeable = true; //找到相同的字符，且可以用来戳成*
                    i ++;
                    j ++;
                }

                if(changeable && j == stampLen){//有字符可以用来戳&&遍历完这这个substring，和stamp匹配
                    changed = true;
                    res.add(start);//在start戳stamp，加进结果里
                    //遍历一遍这个substring，把所有不是*的字符改成*
                    i--;
                    while(i >= start){
                        if(targetArray[i] != '*'){
                            count ++;
                            targetArray[i] = '*';
                        }
                        i--;
                    }
                }
            }
        }

        if(count != targetLen)//没有把target里所有字符都变成*，无解
            return new int[0];
        else{ //把结果逆序返回
            Collections.reverse(res);
            int len = res.size();
            int[] resArray = new int[len];
            for(int index = 0; index < len; index++){
                resArray[index] = res.get(index);
            }
            return resArray;
        }
    }
}
