package array;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        //sliding window
        int length = nums.length;
        int min = length+1;
        int sum = 0;
        int left = 0;

        for(int i = 0; i < length; i++){
            sum += nums[i];
            while(sum >= s && left <= i){
                min = Math.min(min, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if(min == length+1)
            return 0;
        else
            return min;
    }
}
