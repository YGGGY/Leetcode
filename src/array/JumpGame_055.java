package array;

public class JumpGame_055 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max)//前面的点cannot reach到i点
                return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
