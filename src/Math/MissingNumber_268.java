package Math;
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int len = nums.length;
        int all = (len+1) * len / 2;
        return all - sum;
    }
}

//这题用hashset或者int[]也能做，但是要O(n)space，用sort的话要O(nlon)time
//题目followup要求用O(1)space和O(n)time
//从数学的角度考虑，0~n相加为(1+n)n/2，如果中间少了个数的话，用sum -（1+n)n/2，得到的就是少的那个数