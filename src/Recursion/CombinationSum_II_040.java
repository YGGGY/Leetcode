package Recursion;

import java.util.*;

public class CombinationSum_II_040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(output, new ArrayList<Integer>(), candidates, target, 0);
        return output;
    }

    private void recursion(List<List<Integer>> output, List<Integer> temp, int[] nums, int remain, int start){
        if(remain == 0)
            output.add(new ArrayList<Integer>(temp));
        else if(remain < 0)
            return;//剪枝
        else{
            for(int i=start; i<nums.length; i++){
                if(i>start && nums[i] == nums[i-1])
                    continue; //在start后面，有2个一样的元素，选了后面的元素，
                //说明同深度下前面有选了前面的元素的，是重复的
                temp.add(nums[i]);
                recursion(output, temp, nums, remain-nums[i], i+1);//因为每个数只能用一次，所以这里是i+1
                temp.remove(temp.size()-1);
            }
        }
    }
}
