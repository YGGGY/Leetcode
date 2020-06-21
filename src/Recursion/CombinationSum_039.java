package Recursion;
import java.util.*;

public class CombinationSum_039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(output, new ArrayList<Integer>(), candidates, target, 0);
        return output;
    }

    private void recursion(List<List<Integer>> output, List<Integer> temp, int[] nums, int remain,int start){
        if(remain == 0)
            output.add(new ArrayList<Integer>(temp));
        else if(remain < 0)//剪枝
            return;
        else{
            for(int i=start; i<nums.length; i++){
                temp.add(nums[i]);
                recursion(output, temp, nums, remain-nums[i], i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
