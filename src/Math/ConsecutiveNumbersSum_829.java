package Math;

public class ConsecutiveNumbersSum_829 {
    public int consecutiveNumbersSum(int N) {
        int kMax = (int)(Math.sqrt(2*N + 0.25) - 0.5);
        int count = 0;
        for(int k = 1; k <= kMax; k++){
            if( (N - k*(k+1)/2) % k == 0)
                count ++;
        }
        return count;
    }
}

//先用求和公式求(x+1)(x+2)...(x+k)的和，这个和要等于N
//化开来得到 x = N/k - (k+1)/2
//x要满足两个条件 ①x是正数 ②x是整数
//条件一要求 N/k - (k+1)/2 >= 0 可以得到 k的范围
//在这个k的范围内将k从1遍历到上限，所有求出来的整数就是可能的x，解法加一