package BinarySearch;

public class MedianOfTwoSortedArrays_004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        int len = lenA + lenB;

        if(lenA > lenB) return findMedianSortedArrays(nums2, nums1);//默认array1为短的那个
        if(lenA == 0)   return ((double)(nums2[(lenB-1)/2] + nums2[lenB/2]))/2;//只有array2有数，那就直接取中间两个数

        int start = 0, end = lenA;
        while(start <= end){//二分法在array1上找cutA
            int cutA = (start + end)/2;
            int cutB = (len + 1)/2 - cutA;//如果len为奇数的话，median为线左边
            int L1 = (cutA == 0)? Integer.MIN_VALUE : nums1[cutA-1];
            int L2 = (cutB == 0)? Integer.MIN_VALUE : nums2[cutB-1];
            int R1 = (cutA == lenA)? Integer.MAX_VALUE : nums1[cutA];
            int R2 = (cutB == lenB)? Integer.MAX_VALUE : nums2[cutB];
            //需要满足
            if(L1 > R2)
                end = cutA -1; //L1 > R2, cutA 往左找
            else if(L2 > R1)
                start = cutA + 1; //L2 > R1， cutB往左找 => cutA往右找
            else{
                if(len % 2 == 0)
                    return (double)(Math.max(L1, L2) + Math.min(R1, R2))/2;
                else
                    return Math.max(L1, L2);//如果len为奇数的话，median为线左边
            }
        }
        return -1;
    }
}

//合并后的median其实就是就是这个数左边的都比它小，右边的都比它大。
// 只要找到array1和array2上对应的分割线，线左边max的为median左边，线右边min为median右边
//思路是找到把array1和array2分成两半的那两个cut，两个cut的左边是合并后的左边，两个cut的右边是合并后的右边
//所以是用二分法找array1上的cut，array2的cut会因为m+n/2而确定
//分完变成 X X X L1 || R1 X X
//      X X X X L2 || R2 X X X
//要满足L1 <= R2, L2 <= R1 (L1<=R1和L2<=R2不言而喻）
//找到后再根据奇偶来求median