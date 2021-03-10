package Greedy;
import java.util.*;

public class IntegerToRoman_012 {
    public String intToRoman(int num) {
        int current = 0;
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] alpha = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alpha.length; i++){
            while(current + value[i] <= num){
                sb.append(alpha[i]);
                num -= value[i];
            }
        }
        String ans = sb.toString();
        return ans;
    }
}

//本来是想用/和%来一点点算的，但是每次要遍历的数太多了而且好难算
//转换方向，从小往大算，把所有的可能的阶梯数列出来。
//能加上这层的数还不超过目标数，就把它加上去，不能就到下一个数，直到两数相等加完