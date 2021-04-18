package Bit;

public class FindXORSumOfAllPairsBitwiseAND_1835 {
    public int getXORSum(int[] arr1, int[] arr2) {
        int ans1 = 0, ans2 = 0;
        for(int a : arr1){
            ans1 ^= a;
        }

        for(int b : arr2){
            ans2 ^= b;
        }

        return ans1 & ans2;
    }
}


//其实是反向用分配律
//(a1 ^ a2) & (b1 ^ b2) = (a1 & b1) ^ (a1 & b2) ^ (a2 & b1) ^ (a2 & b2)
//所以可以先把arr[]内部的XOR完再把两个array的结果AND