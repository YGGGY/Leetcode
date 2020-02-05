package array;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int zeroes = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
            else
                zeroes ++;
        }
        int i = nums.length - 1;
        while(zeroes > 0){
            nums[i] = 0;
            i--;
            zeroes--;
        }
    }
}
