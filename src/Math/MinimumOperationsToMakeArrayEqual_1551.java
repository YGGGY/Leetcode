package Math;

public class MinimumOperationsToMakeArrayEqual_1551 {
    public int minOperations(int n) {
        if(n % 2 == 0)
            return n * n / 4;
        else
            return (n * n - 1) / 4;
    }
}
//纯数学题 找规律
//等差数列求和可知，sum为n^2，所以每个数要改为n
//分奇偶两种情况，只考虑半边，另外半边是对称的，把加的数减掉就是了
//偶数个是n/2个+1，+3，+5……用等差数列算出答案
//奇数个是(n-1)/2个+2,+4,+6……用等差数列算出答案
//