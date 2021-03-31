package DP;
import java.util.*;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;

        int n = nums.length;
        int[] dp = new int[n];//dp[i]：以nums[i]为结尾的增序列的max length
        Arrays.fill(dp, 1);  //初始化：dp[i] = 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        //找出最长的返回
        int res = 1;
        for(int i = 0; i < n; i ++)
            res = Math.max(res, dp[i]);
        return res;
    }

    //Time：O(n^2)
    //Space: O(n)

    //--------------------------------------------------
    //蜘蛛纸牌的思想，把数放到left most eligible的pile上，新的大的数放不了就放到新的pile上
    //最后piles数就是LIS长度
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] piles = new int[n];//用来存每个pile最小的数（即最下面那个数）
        int numOfPiles = 0;
        for(int num : nums){
            int destPile = Arrays.binarySearch(piles, 0, numOfPiles, num);//返回已有的pile index
            if(destPile < 0)//不在pile里
                destPile = - (destPile + 1);//不在时会return -(index+1)
            piles[destPile] = num;//更新这个pile的最小数
            if(destPile == numOfPiles)//存在新的pile里了
                numOfPiles ++;
        }
        return numOfPiles;
    }
    //Time: O(nlogn) 每个数都只找一次，每次要在piles里Binarysearch要logn时间
    //Space: O(n)
}
