package Greedy;
import java.util.*;

public class MinimumAbsoluteSumDifference_1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sumDiff = 0;
        int maxDiff = 0;
        int maxDiffIndex = -1;
        for(int i = 0; i < n; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            sumDiff = (sumDiff + diff) % 1000000007;
            maxDiff = Math.max(maxDiff, diff);
            if(maxDiff == diff)
                maxDiffIndex = i;
        }

        int toBeChanged = nums1[maxDiffIndex];
        int target = nums2[maxDiffIndex];
        Arrays.sort(nums1);
        int index = Arrays.binarySearch(nums1, target);
        if(index < 0)
            index = -(index+1);
        if(index == 0){
            return sumDiff - (toBeChanged - nums1[0]);
        }
        if(index == n)
            return sumDiff - (nums1[n-1] - toBeChanged);

        int candidate1 = nums1[index], candidate2 = nums1[index-1];
        int diff1 = Math.abs(candidate1 - target), diff2 = Math.abs(candidate2 - target);
        int better = Math.min(diff1, diff2);
        return sumDiff - (maxDiff - better);

    }
}
//找出diff最大的那个nums1[i]和nums2[i]，在nums1里找跟nums2[i]最接近的数，计算能减少多少diff