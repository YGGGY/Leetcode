package Greedy;

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
//Greedy的做法是O(n)
//也可以用boolean dp[i]来做，遍历每个i的nums[i]来使得dp[j]为true，但是这个要O(n^2)