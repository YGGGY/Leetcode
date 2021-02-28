package Greedy;
import java.util.*;

public class EqualSumArraysWithMinimumNumberOfOperations_1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < len1; i++){
            sum1 += nums1[i];
        }
        for(int i = 0; i < len2; i++){
            sum2 += nums2[i];
        }

        if(sum1 == sum2)
            return 0;
        else if(sum1 > sum2){
            int diff = sum1 - sum2;
            int[] candidate = new int[len1+len2];
            for(int i = 0; i < len1; i++){
                candidate[i] = nums1[i] - 1;
            }
            for(int j = 0; j < len2; j++){
                candidate[len1+j] = 6 - nums2[j];
            }
            Arrays.sort(candidate);
            int ans = 0;
            for(int i = len1+len2-1; i >= 0; i--){
                if(diff - candidate[i] <= 0){
                    ans ++;
                    return ans;
                }
                diff = diff - candidate[i];
                ans ++;
            }
            if(diff == 0)
                return ans;
            else
                return -1;
        }
        else{
            int diff = sum2 - sum1;
            int[] candidate = new int[len1+len2];
            for(int i = 0; i < len2; i++){
                candidate[i] = nums2[i] - 1;
            }
            for(int j = 0; j < len1; j++){
                candidate[len2+j] = 6 - nums1[j];
            }
            Arrays.sort(candidate);
            int ans = 0;
            for(int i = len1+len2-1; i >= 0; i--){
                if(diff - candidate[i] <= 0){
                    ans ++;
                    return ans;
                }
                diff = diff - candidate[i];
                ans ++;
            }
            if(diff == 0)
                return ans;
            else
                return -1;
        }
    }
}

//greedy的思想
//计算出sum1和sum2，
//如果sum1>sum2，遍历nums1和nums2
//将nums[i]-1和6-nums2[j]存入新的数组中（即，能对nums1和nums2每个数进行的操作大小
//将新数组排序，从大到小用来减掉sum1和sum2的差值diff，减一次操作数+1。如果最后diff没减完，说明做不到，返回-1
