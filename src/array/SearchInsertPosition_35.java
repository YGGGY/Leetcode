package array;

public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length-1;


        while(left <= right){//left == right的时候如果能取到值，就是刚好在这位置
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        //left > right, nums[right] < target < nums[left]
        //插在右边的位置上，即left处(过一遍例子就知道了)
        return left;
    }
}
