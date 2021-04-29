package BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray_034 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        int start = -1, end = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                start = mid;
                end = mid;
                break;
            }
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        while(start-1 >= 0 && nums[start-1] == target){
            start --;
        }
        while(end+1 < n && nums[end+1] == target){
            end ++;
        }
        int[] ans = new int[2];
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
}
//二分法找到任意一个target所在index，再左右找找有没有相同的
