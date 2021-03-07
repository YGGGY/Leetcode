package Greedy;

public class MinimumElementsToAddToFormAGivenSum_1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        long diff = goal - sum;
        if(diff == 0)   return 0;

        diff = Math.abs(diff);
        long ans =  (long)diff / limit;
        if(diff % limit != 0)
            ans ++;
        return (int)ans;
    }
}
//思路是很普通的greedy，只是数太大了，不能用int要用long
