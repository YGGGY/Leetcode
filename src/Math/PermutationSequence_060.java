package Math;

import java.util.*;

public class PermutationSequence_060 {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new LinkedList<>();

        //把数字填入linkedlist，并且计算 (n-1)!
        int weight = 1;
        for(int i = 1; i <= n; i++){
            digits.add(i);
            if(i == n)
                break;
            weight = weight * i;
        }

        String res = "";
        k = k - 1;//-1后答案才对
        while(true){
            res = res + digits.remove(k / weight);
            k = k % weight;
            if(digits.isEmpty())
                break;
            weight = weight / digits.size();
        }
        return res;
    }
}
