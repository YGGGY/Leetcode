package array;

public class FirstMissiingPositive_041 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)    return 1;

        //第一次for loop把能放到正确位置上的正整数放到正确位置上
        for(int i = 0; i < nums.length; i++){
            //0 < nums[i] <= nums.length 说明nums[i]是个valid positive number, 即num应该能放到index == num-1的这个位置上
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                //值为nums[i]的数应该放到index == nums[i]-1的位置上，如果这个位置上的数不等于它，就交换
                swap(nums, i, nums[i] - 1);
                //因为每次swap能把nums[i]这个数放到正确位置，n个数最多放n次，所以整个for循环O(n)
            }
        }

        //第二次forloop从小到大查找，第一个没有放正确数的index就是那个缺失的正整数
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;//第二次循环都没有return过的话，说明nums[]里是1234..n，应该返回n+1
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//题目要求用O(n)Time O(1)Space
//用桶排序的思想，nums[i]放i+1这个数
//遍历一次，将数字num放到index==num-1的位置上
//遍历完如果有位置的数不对应，说明缺失了这个数。如果都对应，则最小的missing数是length+1