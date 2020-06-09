package Bit;

public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if(n==0)    return false;

        long x = (long) n;
        if((x & (-x)) == x)
            return true;
        else
            return false;
    }
    //这题的关键是知道这些知识点：
    //一个数如果是2的倍数的话，2进制下它只有1位为1，其他都为0
    //由补数(2's complement)可以知道，数x和-x只有rightmost的1能被保留下来 （其他的1都变成0了，最右边的1变为0后因为+1，又会进位变成1）
    //所以x & (-x)时，只有rightmost的1是相等的，其他x为1的在(-x)为0，在x为0的在(-x)为1，得到的结果就是其他位都为0，只有rightmost的1还是1
    //也就是说，x & (-x)时会将rightmost的1保留下来，其他所有位都变为0
    //所以如果x & (-x)后，还等于x的话，说明原本x只有1位为1，所以是2的倍数

    //---------------------------

    public boolean isPowerOfTwo2(int n) {
        if(n==0)    return false;

        long x = (long) n;
        if((x & (x-1)) == 0)
            return true;
        else
            return false;
    }

    //x-1会让rightmost的1变为0，lower bits的0变为1
    //x & (x-1)会让x的rightmost的1和其他lower bits都为0，其他位不变
    //如果x只有一个1的话，即rightmost的1前面都是0，得出来的结果就是0
    //如果x不只一个1的话，在rightmost的1前面的1会被保留，得出来的结果不是0
}

