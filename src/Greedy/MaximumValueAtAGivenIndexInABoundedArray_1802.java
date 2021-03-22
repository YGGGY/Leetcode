package Greedy;

public class MaximumValueAtAGivenIndexInABoundedArray_1802 {
    //-----------------------------------------------------
    //greedy，先造金字塔，造完再每个数都+1，直到maxsum用完
    public int maxValue(int n, int index, int maxSum) {
        int remainSum = maxSum - n;//suppose array fills with 1
        int peak = 1;
        int round = 1;
        //每次peak+1，周围的+1，形成金字塔形
        while(round <= index || round <= n - index - 1){ //左边的个数&&右边的个数
            peak ++;
            int left = Math.min(round-1, index); //第一个round只加peak，后续加满了就不加这半边
            int right = Math.min(round-1, n-index-1); //第一个round只加peak，后续加满了就不加这半边
            remainSum -= left + right + 1;//左边round-1个，右边round-1个，和peak自己，都+1
            if(remainSum < 0){//还没凑出金字塔，就不够remain来加了
                peak --;
                break;
            }
            round ++;
        }

        //金字塔以后就是每次每个数都+1，不满足每个数都+1的那轮不能使peak+1
        if(remainSum > 0)
            peak += remainSum / n;
        return peak;
    }

    //-----------------------------------------------------
    //binary search， 在0-maxSum里找合适的数作为peak，计算最小和是否超过maxsum
    public int maxValue2(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        int ans = 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(check(n, index, maxSum, mid)){
                ans = mid;
                left = mid+1;
            }
            else
                right = mid-1;
        }
        return ans;
    }

    private boolean check(int n, int index, int maxSum, int peak){
        long sum = getSum(peak, index+1) + getSum(peak, n-index) - peak;
        if(sum > maxSum)
            return false;
        else
            return true;
    }

    private long getSum(int peak, int length){
        long sum = 0;
        if(length <= peak)
            sum = (long)((peak-length+1)+peak) * length / 2;
        else
            sum = (long)(1+peak)*peak/2 + (length - peak);
        return sum;
    }

}
