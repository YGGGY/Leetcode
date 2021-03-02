package HashMap;
import java.util.*;

public class SetMismatch_645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int i = 1; i <= nums.length; i++){
            if(!map.containsKey(i))
                ans[1] = i;
            else if(map.get(i) == 2)
                ans[0] = i;
        }
        return ans;
    }
}
//不用hashmap,用一个int[]来记录出现次数也可以，array[index]表示index出现过的次数