package array;
import java.util.*;

public class TwoSum_001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            //对每个值，找他相对target的补数在已有的map中存不存在
            if(map.containsKey(target - nums[i])){//找有没有key存在是这个值
                result[1] = i;
                result[0] = map.get(target - nums[i]);//用这个key来get对应的value
                return result;
            }
            map.put(nums[i], i);//nums[index]作为key，index作为value
                                //因为给的api是找key存不存在的
        }
        return result;
    }
}

//用HashMap做