package array;
import java.util.*;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){//注意因为下面有i+1，所以i的上界要-1
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
