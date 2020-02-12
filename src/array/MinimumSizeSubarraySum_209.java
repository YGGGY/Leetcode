package array;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int min = length+1;
        int sum = 0;
        int left = 0;
        //left和i分别作为sliding window的两个边界，sum为从left加到i
        for(int i = 0; i < length; i++){
            sum += nums[i];
            //找到符合的sum后，开始收缩left
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
//用sliding window做
//为什么找到符合的sum后收缩left能保证得到min呢？->
//因为符合的sum时的window size是目前最小的size，后续的size应该小于这个size才是possible answer
//对目前的right边界来说，看看能不能通过变大left来减小window size
//目前的min size和window size能通过min变量一直保存下去，看后续变化是否使min变小