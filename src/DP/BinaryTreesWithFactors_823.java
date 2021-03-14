package DP;
import java.util.*;

public class BinaryTreesWithFactors_823 {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }

        long dp[] = new long[arr.length]; //dp[i]：以i为root有多少种binary tree
        Arrays.fill(dp, 1);//至少有1个binary tree

        //找出能被i整除的j，再算出另个一个因子k，这两个就是i的左右子树的根，把左右子树数量相乘
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ;j < i; j++){
                if(arr[i] % arr[j] == 0){ //i可以整除j
                    int factor = arr[i]/arr[j]; //算出另一个乘数k
                    if(map.containsKey(factor))
                        dp[i] = (dp[i] + dp[j] * dp[map.get(factor)]) % mod;
                        //dp[i] = dp[i] + dp[j] * dp[k] root的二叉树数量 = 左子树数量*右子树数量
                }
            }
        }
        long ans = 0;
        for(long temp : dp)//把所有node为root的二叉树数量加在一起
            ans += temp;
        return (int)(ans % mod);
    }
}
