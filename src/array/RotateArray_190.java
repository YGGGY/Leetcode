package array;

public class RotateArray_190 {
    public void rotate(int[] nums, int k) {
        //1234567 k=3
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);//全部反转 7654321
        reverse(nums, 0, k-1);//反转前面k部分 567 4321
        reverse(nums, k, nums.length-1);//反转后面剩余部分 567 1234
    }

    //将array对称反转：12034-43021
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
