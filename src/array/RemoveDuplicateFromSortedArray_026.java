package array;

//和027.Remove Element类似
public class RemoveDuplicateFromSortedArray_026 {
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i=1; i<nums.length; i++){
            if(nums[i] != nums[ans]){
                ans ++;
                nums[ans] = nums[i];
            }
        }
        ans++;
        return ans;
    }
}
