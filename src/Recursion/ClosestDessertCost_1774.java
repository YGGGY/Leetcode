package Recursion;

public class ClosestDessertCost_1774 {
    private int result = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int i = 0; i < baseCosts.length; i++){
            recursion(0, toppingCosts, target, baseCosts[i]);
        }
        return result;
    }

    private void recursion(int index, int[] nums, int target, int current){
        if(Math.abs(target-current) < Math.abs(target-result) ||
                (Math.abs(target-current) == Math.abs(target-result) && current < result))
            result = current; //符合条件的备选项
        if(index == nums.length || current > target)
            return; //加完了/超出target的别加了

        recursion(index+1, nums, target, current);//不用这个topping
        recursion(index+1, nums, target, current+nums[index]);//用一次这个topping
        recursion(index+1, nums, target, current+nums[index]*2);//用2次这个topping

    }
}
