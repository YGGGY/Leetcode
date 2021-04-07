package Stack;
import java.util.*;

public class DecodeString_394 {
    public String decodeString(String s) {
        Deque<Integer> count = new ArrayDeque();
        Deque<String> stack = new ArrayDeque();

        String repeat = "";
        int index = 0;

        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int times = 0;
                while(Character.isDigit(s.charAt(index))){
                    times = times * 10 + (s.charAt(index) - '0');
                    index ++;
                }
                count.push(times);
            }
            else if(s.charAt(index) == '['){
                stack.push(repeat); //把上一轮的repeat存进去，如果存在nested则这个是等下要+新字符repeat，
                                    // 不存在nested则会为之前的结果
                repeat = "";
                index ++;
            }
            else if(s.charAt(index) == ']'){
                String temp = stack.pop(); //把stack里的repeat提出来，如果nested的话就是要加上去的repeat，没有nested的话会是个""
                int times = count.pop();
                while(times > 0){      //repeat部分加times次
                    temp = temp + repeat;
                    times --;
                }
                repeat = temp;
                index ++;
            }
            else{  //把当前需要重复的字符存为repeat
                repeat = repeat + s.charAt(index);
                index ++;
            }
        }
        return repeat;
    }
}
