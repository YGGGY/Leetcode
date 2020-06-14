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
    //Bottom-up DP
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n == 0)  return new ArrayList();

        //每一个EDS是一个ArrayList，EDS是一个ArrayList of ArrayList
        List<ArrayList> EDS = new ArrayList();
        for(int num : nums)
            EDS.add(new ArrayList());

        Arrays.sort(nums);

        //calculate all the EDS(Xi)---Bottom-up
        for(int i = 0; i < n; i++){//EDS(i)

            //找i之前的最大的subset，且这个subset能加上nums[i]成为新的subset
            List<Integer> maxSubset = new ArrayList();
            for(int k = 0; k < i; k++){
                //nums[i] % nums[k] == 0是第一条：if h % G == 0, [E, F, G, h]
                if(nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size())
                    maxSubset = EDS.get(k);

            }
            //把之前的最大的subset加上nums[i] 成为新的EDS(i)
            EDS.get(i).addAll(maxSubset);
            EDS.get(i).add(nums[i]);
        }

        //find the largest EDS
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < n; i++){public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            if(n == 0)  return new ArrayList();

            //每一个EDS是一个ArrayList，EDS是一个ArrayList of ArrayList
            List<ArrayList> EDS = new ArrayList();
            for(int num : nums)
                EDS.add(new ArrayList());

            Arrays.sort(nums);

            //calculate all the EDS(Xi)---Bottom-up
            for(int i = 0; i < n; i++){//EDS(i)

                //找i之前的最大的subset，且这个subset能加上nums[i]成为新的subset
                List<Integer> maxSubset = new ArrayList();
                for(int k = 0; k < i; k++){
                    //nums[i] % nums[k] == 0是第一条：if h % G == 0, [E, F, G, h]
                    if(nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size())
                        maxSubset = EDS.get(k);

                }
                //把之前的最大的subset加上nums[i] 成为新的EDS(i)
                EDS.get(i).addAll(maxSubset);
                EDS.get(i).add(nums[i]);
            }

            //find the largest EDS
            List<Integer> ans = new ArrayList();
            for (int i = 0; i < n; i++){
                if(ans.size() < EDS.get(i).size())
                    ans = EDS.get(i);
            }
            return ans;
        }
            if(ans.size() < EDS.get(i).size())
                ans = EDS.get(i);
        }
        return ans;
    }
    //Time: O(n^2)
    //Space: O(n^2)



    //-------------------------------------------------
    //同样的做法，但是只记录EDS[Xi]的大小，因为实际上也用不到Xi前面的数，从而节省space
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        int n = nums.length;
        if(n == 0)  return new ArrayList();

        int[] dp = new int[n];

        Arrays.sort(nums);

        int maxSubset = -1;
        int maxSubsetIndex = -1;

        //calculate all the EDS(Xi)---Bottom-up
        for(int i = 0; i < n; i++){//EDS(i)

            //找i之前的最大的subset，且这个subset能加上nums[i]成为新的subset
            int subset = 0;
            for(int k = 0; k < i; k++){
                //nums[i] % nums[k] == 0是第一条：if h % G == 0, [E, F, G, h]
                if(nums[i] % nums[k] == 0 && subset < dp[k])
                    subset = dp[k];
            }
            dp[i] = subset + 1;

            //find the largest EDS
            if(maxSubset < dp[i]){
                maxSubset = dp[i];
                maxSubsetIndex = i;
            }
        }

        //reconstruct the largest EDS
        LinkedList<Integer> ans = new LinkedList();
        int currSize = maxSubset;
        int currTail = nums[maxSubsetIndex];
        for(int i = maxSubsetIndex; i >= 0; i--){//从后往前重构，从最大数开始
            if(currSize == 0)   break;

            //if E % d == 0, [d, E, F, G]
            //currTail是目前的最左边的数
            if(currTail % nums[i] == 0 && currSize == dp[i]){
                ans.addFirst(nums[i]);
                currTail = nums[i];
                currSize -= 1;
            }
        }

        return ans;
    }

    //Time: O(n^2)
    //Space : O(n)



    //------------------------------------------
    //



}

//这题要用到的数学规则：
//for subset [E, F, G], if h%G == 0, {E, F, G, h]
//for subset [E, F, G], if E%d == 0, {d, E, F, G]
//EDS[Xi]是Xi作为最后一个数的最大的divisible subset，从EDS[0]一直计算到EDS[n-1]
//最大的EDS就是largest divisible subset