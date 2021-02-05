package Recursion;

public class FibonacciNumber_509 {
    //recursion
    public int fib(int N) {
        if(N==0)   return 0;
        if(N==1)    return 1;
        else
            return fib(N-1) + fib(N-2);
    }
    //Time: O(2^n)
    //Space: O(n)

    //可以用数组把中间fib(i)的记录下来，能把time节省到O(n)

    //----------------------
    //Bottom-up iteration with memo
    public int fib2(int n) {
        int[] memo = new int[n+1];
        if(n == 0)  return 0;
        if(n == 1 || n == 2)  return 1;
        memo[1] = 1;
        memo[2] = 1;
        for(int i = 3; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
    //Time: O(n)
    //Space: O(n)

    //可以用2个变量来代替memo[i-1]和memo[i-2]的角色，这样只用O(1)space

}
