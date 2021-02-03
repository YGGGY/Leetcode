package BinarySearch;
import java.util.*;

public class SearchInRotatedSortedArray_033 {
    public int search(int[] rotatedArray, int target) {
        if(rotatedArray == null || rotatedArray.length == 0)  return -1;

        //二分法找rotate的位置，start为rotate后最小的那个点
        int length = rotatedArray.length;
        int left = 0;
        int right = length-1;
        int start = -1;
        int mid = -1;
        if(rotatedArray[0] <= rotatedArray[length-1])//解决没有rotate/只有一个数的情况
            start = 0;
        else{
            while(left < right){//用right = mid+1 && left <= right那种二分法做的话会错过，只能用这个
                mid = (left + right)/2;
                //解决left/right == mid的时候陷入循环的情况
                if(rotatedArray[mid] > rotatedArray[mid+1]){
                    start = mid+1;
                    break;
                }
                if(rotatedArray[left] > rotatedArray[mid]){
                    right = mid;
                }
                else if(rotatedArray[mid] > rotatedArray[right])
                    left = mid;
                else{
                    start = mid;
                    break;
                }
            }

        }


        if(rotatedArray[length-1] == target)
            return length-1;
        else if(rotatedArray[length-1] > target){
            int ans = binarySearch(Arrays.copyOfRange(rotatedArray, start, length), target);
            return (ans == -1)? -1 : ans + start;
        }
        else{
            if(start == 0){
                return (rotatedArray[0] == target)? 0 : -1;
            }
            else
                return binarySearch(Arrays.copyOfRange(rotatedArray, 0, start), target);
        }
    }

    private int binarySearch(int[] array, int target){
        if(array == null || array.length == 0)  return -1;
        if(array.length == 1) return (array[0] == target)? 0 : -1;

        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(array[mid] == target)
                return mid;
            else if(array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    //O(logn)时间复杂度
    //先用二分法找出rotate的位置，再确定是从左半边还是右半边找（用二分法找target)
    //思路不算复杂，但是很多Corner case要debug

    //找rotate位置，我做的方法是区间头尾比较，其实可以直接找一个点mid，使得mid点大于后一个点，这样二分法好写多了

    //-----------------------------------------
    //one-pass binary search
    //画一下柱状图就能发现，rotated后面的数都比array[0]的数小
    //可以通过nums[mid]和nums[left]进行比较来知道mid是否在rotated的部分
    public int search2(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] >= nums[left]){//mid在没rotated的部分
                if(target >= nums[left] && target <= nums[mid])
                    //target在left~mid这个没rotated的区间，在mid左边
                    right = mid - 1;
                else
                    //target可能在rotated，也可能在没rotated区间。但至少不在mid左边
                    left = mid + 1;
            }
            else{//mid在rotated的部分
                if(target >= nums[mid] && target <= nums[right])
                    //target在mid~right这个rotated的区间，在mid右边
                    left = mid + 1;
                else
                    //target可能在rotated，也可能在没rotated区间。但至少不在mid右边
                    right = mid - 1;
            }
        }
        return -1;
    }
}
