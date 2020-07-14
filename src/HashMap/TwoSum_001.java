package HashMap;
import java.util.*;

public class TwoSum_001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();//<num[i], index i>

        for(int i=0; i<nums.length; i++){
            int remain = target - nums[i];
            if(map.containsKey(remain)){
                result[0] = map.get(remain);
                result[1] = i;
            }
            else
                map.put(nums[i], i);
        }
        return result;
    }
}

//用HashMap做，key-value为数和它在的index
//找map里是否存在remain需要的数，有的话返回当前的index和这个remain的数在的index