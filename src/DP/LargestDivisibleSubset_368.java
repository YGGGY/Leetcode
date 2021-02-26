package DP;
import java.util.*;
/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
 */

public class LargestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(n == 0 || nums == null)  return ans;
        Arrays.sort(nums);

        int[] dp = new int[n];//以nums[i]结尾的最长divisible子集的长度，初始为1
        Arrays.fill(dp, 1);
        int[] prev = new int[n]; //记录nums[i]的前一个被整除的数的index，设个取不到的初始值
        Arrays.fill(prev, -1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){ //j能被i整除，说明j和j的因子都能被i整除
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if(dp[i] == dp[j] + 1)//说明更新了dp[i]
                        prev[i] = j;//把j记录成i的上一个整除数
                }
            }
        }

        int len = 0;
        int index = 0;//LDS在index处end
        for(int i = 0; i < n; i++){
            if(dp[i] > len){
                len = dp[i];
                index = i;
            }
        }


        while(index != -1){
            ans.add(0, nums[index]);
            index = prev[index]; //取上一个约数的index
        }
        return ans;
    }



    //Time: O(n^2)
    //Space : O(n)





}


//这题要用到的数学规则：
//for subset [E, F, G], if h % G == 0, {E, F, G, h]
//for subset [E, F, G], if E % d == 0, {d, E, F, G]
//EDS[Xi]是Xi作为最后一个数的最大的divisible subset，从EDS[0]一直计算到EDS[n-1]
//最大的EDS就是largest divisible subset