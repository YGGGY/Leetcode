package array;

public class RemoveElement_027 {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
}
